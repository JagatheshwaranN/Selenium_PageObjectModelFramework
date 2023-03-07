package com.jtaf.ohrm.pages;

import org.openqa.selenium.By;
import com.jtaf.ohrm.base.Page;

public class LoginPage extends Page {

	public DashboardPage doLogin() {

		_driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		_driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		_driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login-button')]")).click();
		return new DashboardPage();
	}

	public void gotoForgotPasswordPage() {

		_driver.findElement(By.xpath("//p[contains(@class,'login-forgot-header')]")).click();
		_driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		_driver.findElement(By.xpath("//button[contains(@class,'orangehrm-forgot-password-button--reset')]")).click();
	}
}
