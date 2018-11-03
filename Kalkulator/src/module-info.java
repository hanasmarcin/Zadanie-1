
/**
 * @author Marcin Hanas
 *
 */
module application.view {
	
	requires transitive javafx.controls;
	requires transitive javafx.base;
	requires jdk.jshell;
	requires javafx.graphics;
	requires javafx.fxml;
	exports application.view;
	exports application.controller to application.view;
	exports application.model to application.controller;
	opens application.controller to javafx.fxml;
}

