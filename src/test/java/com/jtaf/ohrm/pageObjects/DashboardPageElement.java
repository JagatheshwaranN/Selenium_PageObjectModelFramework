package com.jtaf.ohrm.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import java.util.List;

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
	public String UserDropDown;

	@FindBy(css = ".oxd-dropdown-menu")
	public WebElement userDropDownMenu;
	public String UserDropDownMenu;

	@FindBy(xpath = "//a[contains(@href,'logout')]")
	public WebElement logout;
	public String Logout;

	@FindBy(xpath = "//a[contains(@href,'admin/viewAdminModule')]")
	public WebElement adminSection;
	public String AdminSection;

	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-quick-launch-card']")
	public List<WebElement> quickLaunchCards;
	public String QuickLaunchCards;
}
