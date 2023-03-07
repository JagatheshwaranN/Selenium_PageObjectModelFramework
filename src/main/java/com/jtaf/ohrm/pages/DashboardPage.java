package com.jtaf.ohrm.pages;

import org.openqa.selenium.By;

import com.jtaf.ohrm.base.Page;

public class DashboardPage extends Page {

	public void userDropDown() {

		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		driver.findElement(By.cssSelector(".oxd-dropdown-menu")).isDisplayed();
	}

	public void doLogout() {
		
		userDropDown();
		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
	}
}
