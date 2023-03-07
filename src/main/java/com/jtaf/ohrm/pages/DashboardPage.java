package com.jtaf.ohrm.pages;

import org.openqa.selenium.By;

import com.jtaf.ohrm.base.Page;

public class DashboardPage extends Page {

	public void userDropDown() {

		_driver.findElement(By.className("oxd-userdropdown-tab")).click();
		_driver.findElement(By.cssSelector(".oxd-dropdown-menu")).isDisplayed();
	}

	public void doLogout() {
		userDropDown();
		_driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
	}
}
