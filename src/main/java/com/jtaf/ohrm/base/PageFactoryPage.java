package com.jtaf.ohrm.base;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.jtaf.ohrm.config.Constants;
import com.jtaf.ohrm.utils.ExcelReaderUtil;
import com.jtaf.ohrm.utils.ExtentReportUtil;

public class PageFactoryPage extends Constants {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ChromeOptions options;

	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExtentReports report = ExtentReportUtil.getInstance();
	protected static ExtentTest test;
	public static String browser;
	public static ExcelReaderUtil excelReaderUtil = new ExcelReaderUtil(
			System.getProperty("user.dir") + "/src/test/resources/com/jtaf/excel/testData.xlsx");

	@BeforeMethod
	public static void setup() {

//		if (driver == null) {
			if (System.getenv("Browser") != null && !System.getenv("Browser").isEmpty()) {
				browser = System.getenv("Browser");
			} else {
				browser = Browser;
			}
			if (browser.equalsIgnoreCase("Chrome")) {
				options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				log.debug(browser + " driver started");
			} else if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				log.debug(browser + " driver started");
			} else if (browser.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
				log.debug(browser + " driver started");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ImplicitWait)));
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(WebDriverWaitTime)));
			driver.get(URL);
			log.debug("Driver launches the application " + URL);
//		}
	}

	@AfterMethod
	public static void tearDown() {
		
		driver.quit();
		log.debug("Driver stopped and closed");
	}
}
