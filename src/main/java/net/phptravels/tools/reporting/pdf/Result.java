package net.phptravels.tools.reporting.pdf;

public class Result {

	private static String methodResult = null;

	public static void setResultByMethod(String result) {
		methodResult = result;
	}

	public static String getResultByMethod() {

		return methodResult;

	}
}
