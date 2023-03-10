package com.jtaf.ohrm.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.jtaf.ohrm.common.PFReusableComponent;
import com.jtaf.ohrm.config.Constants;
import com.jtaf.ohrm.pageObjects.DashboardPageElement;

public class PFDashboardPage extends PFLoginPage {

	// PageFactory code
	public DashboardPageElement dashboardPageElement;

	public PFDashboardPage() {

		this.dashboardPageElement = new DashboardPageElement();
		AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver,
				Integer.parseInt(Constants.WebDriverWaitTime));
		PageFactory.initElements(ajaxElementLocatorFactory, this.dashboardPageElement);
	}

	public void pfUserDropDown() {

		elementClick(dashboardPageElement.userDropDown);
		isElementPresent(dashboardPageElement.userDropDownMenu);
	}

	public void pfDoLogout() {

		pfUserDropDown();
		elementClick(dashboardPageElement.logout);
	}

	public PFAdminPage pfNavigateToAdminPage() {

		elementClick(dashboardPageElement.adminSection);
		return new PFAdminPage();
	}
}
