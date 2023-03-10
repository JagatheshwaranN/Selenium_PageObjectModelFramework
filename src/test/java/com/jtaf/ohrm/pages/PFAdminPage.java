package com.jtaf.ohrm.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.jtaf.ohrm.common.PFReusableComponent;
import com.jtaf.ohrm.config.Constants;
import com.jtaf.ohrm.pageObjects.AdminPageElement;

public class PFAdminPage extends PFDashboardPage {

	// PageFactory related code
	public AdminPageElement adminPageElement;

	public PFAdminPage() {

		this.adminPageElement = new AdminPageElement();
//		AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver,
//				Integer.parseInt(Constants.WebDriverWaitTime));
		PageFactory.initElements(driver, this.adminPageElement);
	}

	public void pfSearchUser(String user, String status) {

		isElementPresent(adminPageElement.adminHeader);
		elementType(adminPageElement.adminSearchUserName, user);
		elementSelect(adminPageElement.adminUserRoleDropDown, adminPageElement.adminUserRoleDropDownOptions, user);
		elementSelect(adminPageElement.adminUserStatusDropDown, adminPageElement.adminUserStatusDropDownOptions,
				status);
		elementClick(adminPageElement.adminSearch);
		isElementPresent(adminPageElement.adminSearchResultSection);
		isElementPresent(adminPageElement.adminSearchResultData);
	}
}
