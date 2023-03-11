package com.jtaf.ohrm.pages;

import org.openqa.selenium.support.PageFactory;

import com.jtaf.ohrm.common.PFReusableComponent;
import com.jtaf.ohrm.pageObjects.LoginPageElement;

public class PFLoginPage extends PFReusableComponent {

	public LoginPageElement loginPageElement;

	public PFLoginPage() {

		this.loginPageElement = new LoginPageElement();
//		AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver,
//				Integer.parseInt(Constants.WebDriverWaitTime));
		PageFactory.initElements(driver, this.loginPageElement);
	}

	public PFDashboardPage pfDoLogin(String username, String password) {

		elementType(loginPageElement.userName, username);
		elementType(loginPageElement.passWord, password);
		elementClick(loginPageElement.login);
		return new PFDashboardPage();
	}
}
