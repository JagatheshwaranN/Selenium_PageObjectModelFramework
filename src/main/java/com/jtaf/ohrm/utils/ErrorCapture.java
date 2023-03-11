package com.jtaf.ohrm.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ErrorCapture {

	private static Map<ITestResult, List<Throwable>> verifyFailuresMap = new HashMap<ITestResult, List<Throwable>>();

	public static void validateTrue(boolean condition) {
		Assert.assertTrue(condition);
	}

	public static void validateTrue(boolean condition, String message) {
		Assert.assertTrue(condition, message);
	}

	public static void validateFalse(boolean condition) {
		Assert.assertFalse(condition);
	}

	public static void validateFalse(boolean condition, String message) {
		Assert.assertFalse(condition, message);
	}

	public static void validateEquals(boolean actual, boolean expected) {
		Assert.assertEquals(actual, expected);
	}

	public static void validateEquals(Object actual, Object expected) {
		Assert.assertEquals(actual, expected);
	}

	public static void validateEquals(Object[] actual, Object[] expected) {
		Assert.assertEquals(actual, expected);
	}

	public static void validateEquals(Object actual, Object expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void verifyTrue(boolean condition) {
		try {
			validateTrue(condition);
		} catch (Throwable ex) {
			addVerifyFailure(ex);
		}
	}

	public static void verifyTrue(boolean condition, String message) {
		try {
			validateTrue(condition, message);
		} catch (Throwable ex) {
			addVerifyFailure(ex);
		}
	}

	public static void verifyFalse(boolean condition) {
		try {
			validateFalse(condition);
		} catch (Throwable ex) {
			addVerifyFailure(ex);
		}
	}

	public static void verifyFalse(boolean condition, String message) {
		try {
			validateFalse(condition, message);
		} catch (Throwable ex) {
			addVerifyFailure(ex);
		}
	}

	public static void verifyEquals(boolean actual, boolean expected) {
		try {
			validateEquals(actual, expected);
		} catch (Throwable ex) {
			addVerifyFailure(ex);
		}
	}

	public static void verifyEquals(String actual, String expected) {
		try {
			validateEquals(actual, expected);
		} catch (Throwable ex) {
			addVerifyFailure(ex);
		}
	}

	public static void verifyEquals(Object actual, Object expected) {
		try {
			validateEquals(actual, expected);
		} catch (Throwable ex) {
			addVerifyFailure(ex);
		}
	}

	public static void verifyEquals(Object[] actual, Object[] expected) {
		try {
			validateEquals(actual, expected);
		} catch (Throwable ex) {
			addVerifyFailure(ex);
		}
	}

	public static void validateFail(String message) {
		Assert.fail(message);
	}

	public static List<Throwable> getVerifyFailures() {
		List<Throwable> verifyFailures = verifyFailuresMap.get(Reporter.getCurrentTestResult());
		return verifyFailures == null ? new ArrayList<Throwable>() : verifyFailures;
	}

	public static void addVerifyFailure(Throwable ex) {
		List<Throwable> verifyFailures = getVerifyFailures();
		verifyFailuresMap.put(Reporter.getCurrentTestResult(), verifyFailures);
		verifyFailures.add(ex);
	}
}
