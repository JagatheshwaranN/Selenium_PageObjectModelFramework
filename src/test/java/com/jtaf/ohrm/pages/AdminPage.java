package com.jtaf.ohrm.pages;

import com.jtaf.ohrm.common.ReusableComponent;

public class AdminPage extends ReusableComponent {

	public void searchUser(String user, String status) {

		isElementPresent("adminHeader");
		elementType("adminSearchUserName", user);
		elementSelect("adminUserRoleDropDown", "adminUserRoleDropDownOptions", user);
		elementSelect("adminUserStatusDropDown", "adminUserStatusDropDownOptions", status);
		elementClick("adminSearch");
		isElementPresent("adminSearchResultSection");
		isElementPresent("adminSearchResultData");
	}
}
