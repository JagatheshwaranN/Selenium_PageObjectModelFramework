package com.jtaf.ohrm.listeners;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.Status;
import com.jtaf.ohrm.base.Page;
import com.jtaf.ohrm.common.ReusableComponent;

public class ReportListener extends ReusableComponent implements ITestListener, ISuiteListener {

	public static String messageBody;

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

	public void onStart(ISuite suite) {
		// not implemented
	}

	public void onFinish(ISuite suite) {

	}
}
