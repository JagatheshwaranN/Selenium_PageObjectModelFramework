package com.jtaf.ohrm.pages;

import org.openqa.selenium.By;
import com.jtaf.ohrm.base.Page;

public class LoginPage extends Page {

	public DashboardPage doLogin() {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login-button')]")).click();
		return new DashboardPage();
	}

	public void gotoForgotPasswordPage() {

		driver.findElement(By.xpath("//p[contains(@class,'login-forgot-header')]")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[contains(@class,'orangehrm-forgot-password-button--reset')]")).click();
	}
}
