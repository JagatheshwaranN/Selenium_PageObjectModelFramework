package com.jtaf.ohrm.pages;

import com.jtaf.ohrm.common.ReusableComponent;

public class DashboardPage extends ReusableComponent {

	public void userDropDown() {

		elementClick("userDropDown");
		isElementPresent("userDropDownMenu");
	}

	public void doLogout() {

		userDropDown();
		elementClick("uddLogout");
	}
}
