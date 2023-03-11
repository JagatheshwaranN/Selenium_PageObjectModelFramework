package com.jtaf.ohrm.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class DashboardPageElement {

	/**
	 * @FindBys - It is used to identify an element which is inside the particular
	 *          div /section. For example, in below code, the userDropDown is going
	 *          to be searched inside the UserArea div section only.
	 */

//	@FindBy(css = ".oxd-userdropdown-tab")
//	public WebElement userDropDown;

	@FindBys({ @FindBy(css = ".oxd-topbar-header-userarea"), @FindBy(css = ".oxd-userdropdown-tab") })
	public WebElement userDropDown;

	@FindBy(css = ".oxd-dropdown-menu")
	public WebElement userDropDownMenu;

	@FindBy(xpath = "//a[contains(@href,'logout')]")
	public WebElement logout;

	@FindBy(xpath = "//a[contains(@href,'admin/viewAdminModule')]")
	public WebElement adminSection;

}
