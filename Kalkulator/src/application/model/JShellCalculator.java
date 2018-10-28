package application.model;

import java.util.List;

import jdk.jshell.*;

public class JShellCalculator {

	public boolean isDotBefore() {
		return dotBefore;
	}

	public boolean isOperationBefore() {
		return operationBefore;
	}
	
	public void operationButtonClicked() {
		dotBefore = false;
		operationBefore = true;
	}
	
	public void dotButtonClicked() {
		dotBefore = true;
		operationBefore = false;
	}
	
	public void firstDigitButtonClicked() {
		operationBefore = false;
	}
	
	public String functionName(String buttonValue) {
		switch (buttonValue) {
		case "!":
			return "fact";
		case "x\u00b2":
			return "sqr";
		case "\u221a":
			return "sqrt";
		case "\u00b1":
			return "-";
		}
		return null;
	}

	private final JShell jshell = JShell.create();
	private boolean dotBefore = false;
	private boolean operationBefore = true;

	public JShellCalculator() {
		try {
			jshell.eval("private int fact(int x) { if(x==0) return 1; else return x*fact(x-1); }");
			jshell.eval("private double sqr(double x) { return x*x; }");
			jshell.eval("private double sqrt(double x) { return Math.sqrt(x); }");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isNegative(String input) {
		return input.substring(0, 1).equals("-");
	}

	public String calculate(String input) {

		try {

			List<SnippetEvent> events = jshell.eval(input);
			for (SnippetEvent e : events) {
				if (e.causeSnippet() == null) {
					if(!e.value().equals("Infinity") && !e.value().equals("NaN"))
						return e.value();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}