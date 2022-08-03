package main.java.main.java.utils;

public class Validaciones {
	
	public static void trueBooleanCondition(boolean condition, String successMessage, String errorMessage, String currentEvent) {
		if (condition) {
			utils.outputInfo(successMessage);
		}
		else {
			utils.eventFailed(currentEvent, errorMessage + ": " + condition);
		}
	}

}
