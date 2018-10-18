package application;

import javafx.scene.control.Label;

public class OneArgumentOperationButton extends OperationButton {

	private String functionName;
	
	OneArgumentOperationButton(String operation, String functionName) {
		super(operation);
		this.functionName=functionName;
	}

	@Override
	protected void clickButton(Label inputLabel, Label operationSubjectLabel) {
		Keyboard.setWasOperationPreviously(true);
		inputLabel.setText(functionName + "(" + inputLabel.getText() + ")");
	}

}