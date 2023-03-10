package com.jtaf.ohrm.pages;

import org.openqa.selenium.support.PageFactory;

import com.jtaf.ohrm.common.ReusableComponent;
import com.jtaf.ohrm.pageObjects.DashboardPageElement;

public class DashboardPage extends ReusableComponent {

	// PageFactory related code
	public DashboardPageElement dashboardPageElement;

	public DashboardPage() {

		this.dashboardPageElement = new DashboardPageElement();
		PageFactory.initElements(driver, this.dashboardPageElement);
	}

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
