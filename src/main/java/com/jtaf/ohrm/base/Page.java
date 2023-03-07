package com.jtaf.ohrm.base;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.jtaf.ohrm.utils.ExcelReaderUtil;
import com.jtaf.ohrm.utils.ExtentReportUtil;
import com.jtaf.ohrm.utils.FileReaderUtil;

public class Page extends FileReaderUtil {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ChromeOptions options;

	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExtentReports report = ExtentReportUtil.getInstance();
	public static ExtentTest test;
	public static String browser;
//	public static ExcelReaderUtil excelReaderUtil = new ExcelReaderUtil(
//			System.getProperty("user.dir") + "/src/test/resources/excel/testData.xlsx");

	public Page() {

		if (driver == null) {
			loadPropertyFiles();
			if (System.getenv("Browser") != null && !System.getenv("Browser").isEmpty()) {
				browser = System.getenv("Browser");
			} else {
				browser = getDataFromPropFile("Browser");
			}
			properties.setProperty("Browser", browser);
			if (getDataFromPropFile("Browser").equalsIgnoreCase("Chrome")) {
				options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				driver = new ChromeDriver(options);
				log.debug(getDataFromPropFile("Browser") + " driver started");
			} else if (getDataFromPropFile("Browser").equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				log.debug(getDataFromPropFile("Browser") + " driver started");
			} else if (getDataFromPropFile("Browser").equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
				log.debug(getDataFromPropFile("Browser") + " driver started");
			}

			driver.manage().window().maximize();
			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(getDataFromPropFile("implicit.wait"))));
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			driver.get(getDataFromPropFile("url"));
			log.debug("Driver launches the application " + getDataFromPropFile("url"));
		}
	}
}
