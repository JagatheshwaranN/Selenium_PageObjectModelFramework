package com.jtaf.ohrm.pages;

import com.jtaf.ohrm.common.ReusableComponent;

public class DashboardPage extends ReusableComponent {

	// PageObjectModel basics code
	public void userDropDown() {

		elementClick("userDropDown");
		isElementPresent("userDropDownMenu");
	}

	// PageObjectModel basics code
	public void doLogout() {

		userDropDown();
		elementClick("logout");
	}

	// PageObjectModel basics code
	public AdminPage navigateToAdminPage() {

		elementClick("adminSection");
		return new AdminPage();
	}
}
