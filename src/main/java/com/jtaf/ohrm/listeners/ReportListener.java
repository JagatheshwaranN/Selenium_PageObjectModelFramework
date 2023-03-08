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

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.jtaf.ohrm.base.Page;
import com.jtaf.ohrm.utils.EmailConfig;
import com.jtaf.ohrm.utils.EmailTriggerUtil;
import com.jtaf.ohrm.utils.TestUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;

public class ReportListener extends Page implements ITestListener, ISuiteListener {

	public static String messageBody;

	public void onTestStart(ITestResult result) {

		test.log(Status.INFO, result.getName().toUpperCase() + " Test Started");
	}

	public void onTestSuccess(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		TestUtil.waitForSomeTime();
		String passTestCaseBase64Snapshot = ((TakesScreenshot) Page.driver).getScreenshotAs(OutputType.BASE64);
		test.pass(result.getName().toUpperCase() + " Test Passed",
				MediaEntityBuilder.createScreenCaptureFromBase64String(passTestCaseBase64Snapshot).build());
		String screenToAttach = captureSnapShot();
		Reporter.log("<br>");
		Reporter.log(result.getMethod().getMethodName() + " Test Passed..!!");
		Reporter.log("<br>");
		Reporter.log("<a target='_blank' href='" + screenToAttach + "'><img src= '" + screenToAttach
				+ "' height='100' width='100' /></a>");
	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		TestUtil.waitForSomeTime();
		String failTestCaseBase64Snapshot = ((TakesScreenshot) Page.driver).getScreenshotAs(OutputType.BASE64);
		test.fail(result.getName().toUpperCase() + " Test Passed",
				MediaEntityBuilder.createScreenCaptureFromBase64String(failTestCaseBase64Snapshot).build());
		String screenToAttach = captureSnapShot();
		Reporter.log("<br>");
		Reporter.log(result.getMethod().getMethodName() + " Test Failed..!!");
		Reporter.log("<br>");
		Reporter.log("<a target='_blank' href='" + screenToAttach + "'><img src= '" + screenToAttach
				+ "' height='100' width='100' /></a>");
	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, result.getName().toUpperCase() + " Test Skipped. At the RunMode is set to N");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {

		test = report.createTest(context.getName());
	}

	public void onFinish(ITestContext context) {

		report.flush();
	}

	public void onStart(ISuite suite) {
		// not implemented
	}

	public void onFinish(ISuite suite) {

//		EmailTriggerUtil emailTriggerUtil = new EmailTriggerUtil();
//		try {
//			String[] reportPath = getDataFromPropFile("automationReportPath").split("\\$");
//			messageBody = reportPath[0] + InetAddress.getLocalHost().getHostAddress() + reportPath[1];
//			emailTriggerUtil.sendEmail(EmailConfig.mailServer, EmailConfig.from, EmailConfig.to, EmailConfig.subject,
//					messageBody);
//		} catch (UnknownHostException ex) {
//			ex.printStackTrace();
//		}
	}

	public static String captureSnapShot() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "/src/test/resources/com/jtaf/screenshots/"
				+ simpleDateFormat.format(calendar.getTime()) + ".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return destination.getAbsolutePath();
	}
}
