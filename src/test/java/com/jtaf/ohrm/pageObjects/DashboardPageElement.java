package com.jtaf.ohrm.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageElement {

	@FindBy(css = ".oxd-userdropdown-tab")
	public WebElement userDropDown;

	@FindBy(css = ".oxd-dropdown-menu")
	public WebElement userDropDownMenu;

	@FindBy(xpath = "//a[contains(@href,'logout')]")
	public WebElement logout;

	@FindBy(xpath = "//a[contains(@href,'admin/viewAdminModule')]")
	public WebElement adminSection;

}
