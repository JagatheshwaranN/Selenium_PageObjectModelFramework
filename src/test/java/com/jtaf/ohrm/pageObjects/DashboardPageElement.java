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
	public String userDropDownLabel = "UserDropDown";

	@FindBy(css = ".oxd-dropdown-menu")
	public WebElement userDropDownMenu;
	public String userDropDownMenuLabel = "UserDropDownMenu";

	@FindBy(xpath = "//a[contains(@href,'logout')]")
	public WebElement logout;
	public String logoutLabel = "Logout";

	@FindBy(xpath = "//a[contains(@href,'admin/viewAdminModule')]")
	public WebElement adminSection;
	public String adminSectionLabel = "AdminSection";

	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-quick-launch-card']")
	public List<WebElement> quickLaunchCards;
	public String quickLaunchCardsLabel = "QuickLaunchCards";
}
