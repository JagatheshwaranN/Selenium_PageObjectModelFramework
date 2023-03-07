package com.jtaf.ohrm.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Page {

	public static WebDriver _driver;

	public Page() {
		if (_driver == null) {
			_driver = new ChromeDriver();
			_driver.manage().window().maximize();
			_driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			_driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		}
	}
}
