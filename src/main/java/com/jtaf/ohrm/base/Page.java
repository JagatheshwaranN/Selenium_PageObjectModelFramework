package com.jtaf.ohrm.base;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.jtaf.ohrm.utils.ExcelReaderUtil;
import com.jtaf.ohrm.utils.ExtentReportUtil;
import com.jtaf.ohrm.utils.FileReaderUtil;

public class Page extends FileReaderUtil {

	public static WebDriver driver;
	public static ChromeOptions options;

	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReaderUtil excelReaderUtil = new ExcelReaderUtil(
			System.getProperty("user.dir") + "/src/test/resources/excel/testData.xlsx");
	public static WebDriverWait wait;
	public static ExtentReports report = ExtentReportUtil.getInstance();
	public static ExtentTest test;
	public static String browser;

	public Page() {

		if (driver == null) {
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		}
	}
}
