package com.jtaf.ohrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jtaf.ohrm.pageObjects.DashboardPageElement;

public class PFDashboardPage extends PFLoginPage {

	public DashboardPageElement dashboardPageElement;

	public PFDashboardPage() {

		this.dashboardPageElement = new DashboardPageElement();
//		AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver,
//				Integer.parseInt(Constants.WebDriverWaitTime));
		PageFactory.initElements(driver, this.dashboardPageElement);
	}

	public void pfUserDropDown() {

		elementClick(dashboardPageElement.userDropDown, dashboardPageElement.userDropDownLabel);
		isElementPresent(dashboardPageElement.userDropDownMenu, dashboardPageElement.userDropDownMenuLabel);
	}

	public void pfDoLogout() {

		pfUserDropDown();
		elementClick(dashboardPageElement.logout, dashboardPageElement.logoutLabel);
	}

	public PFAdminPage pfNavigateToAdminPage() {

		elementClick(dashboardPageElement.adminSection, dashboardPageElement.adminSectionLabel);
		return new PFAdminPage();
	}

	public List<WebElement> getQuickLaunchCards() {
		return dashboardPageElement.quickLaunchCards;
	}
}
