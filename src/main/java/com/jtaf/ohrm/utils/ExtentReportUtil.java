package com.jtaf.ohrm.utils;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {

	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extentReports;

	public static ExtentReports getInstance() {
		return extentReports;

	}
}