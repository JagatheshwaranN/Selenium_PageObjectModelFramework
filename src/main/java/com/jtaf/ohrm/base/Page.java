package com.jtaf.ohrm.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Page {

	public static WebDriver _driver;
	public static ChromeOptions _options;

	public Page() {
		
		if (_driver == null) {
			_options.addArguments("--disable-extensions");
			_options.addArguments("--disable-infobars");
			_driver = new ChromeDriver(_options);
			_driver.manage().window().maximize();
			_driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			_driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		}
	}
}
