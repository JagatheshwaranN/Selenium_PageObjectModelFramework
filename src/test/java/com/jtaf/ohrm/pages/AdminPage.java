package com.jtaf.ohrm.pages;

import org.openqa.selenium.support.PageFactory;

import com.jtaf.ohrm.common.ReusableComponent;
import com.jtaf.ohrm.pageObjects.AdminPageElement;

public class AdminPage extends ReusableComponent {

	// PageFactory related code
	public AdminPageElement adminPageElement;

	public AdminPage() {

		this.adminPageElement = new AdminPageElement();
		PageFactory.initElements(driver, this.adminPageElement);
	}

	// PageObjectModel basics code
	public void searchUser(String user, String status) {

		isElementPresent("adminHeader");
		elementType("adminSearchUserName", user);
		elementSelect("adminUserRoleDropDown", "adminUserRoleDropDownOptions", user);
		elementSelect("adminUserStatusDropDown", "adminUserStatusDropDownOptions", status);
		elementClick("adminSearch");
		isElementPresent("adminSearchResultSection");
		isElementPresent("adminSearchResultData");
	}

	// PageFactory related code
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
