package com.jtaf.ohrm.listeners;

import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import com.jtaf.ohrm.utils.ErrorCapture;

public class PFTestListener implements IInvokedMethodListener {

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

		Reporter.setCurrentTestResult(testResult);
		if (method.isTestMethod()) {

			List<Throwable> verifyFailures = ErrorCapture.getVerifyFailures();
			// If there are verification failures
			if (verifyFailures.size() > 0) {

				// Set the test to failed
				testResult.setStatus(ITestResult.FAILURE);
				
				// If there is an assertion failure, add it to verifyFailures
				if (testResult.getThrowable() != null) {
					verifyFailures.add(testResult.getThrowable());
				}
				
				int size = verifyFailures.size();
				
				// If there is only one failure just set that
				if (size == 1) {
					testResult.setThrowable(verifyFailures.get(0));
				} else {
					// Create a failure message with all failures and stack traces (except last
					// failure)
					StringBuffer failMessage = new StringBuffer("Multiple Failures(").append(size).append("):\n\n");
					for (int i = 0; i < size - 1; i++) {
						failMessage.append("Failure ").append(i + 1).append(" of ").append(size).append(":\n");
						Throwable throwable = verifyFailures.get(i);
						String fullStackTrace = Utils.longStackTrace(throwable, false);
						failMessage.append(fullStackTrace).append("\n\n");
					}
					
					// Final failure
					Throwable last = verifyFailures.get(size - 1);
					failMessage.append("Failure ").append(size).append(" of ").append(size).append(":\n");
					failMessage.append(last.toString());
					// Set merged Throwable
					Throwable merge = new Throwable(failMessage.toString());
					merge.setStackTrace(last.getStackTrace());
					testResult.setThrowable(merge);
				}
			}
		}
	}
}
