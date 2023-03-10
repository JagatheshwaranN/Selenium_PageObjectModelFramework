package com.jtaf.ohrm.pages;

import org.openqa.selenium.support.PageFactory;

import com.jtaf.ohrm.common.PFReusableComponent;
import com.jtaf.ohrm.pageObjects.LoginPageElement;

public class PFLoginPage extends PFReusableComponent {

	// PageFactory code
	public LoginPageElement loginPageElement;

	public PFLoginPage() {

		this.loginPageElement = new LoginPageElement();
		PageFactory.initElements(driver, this.loginPageElement);
	}

	public PFDashboardPage pfDoLogin(String username, String password) {

		elementType(loginPageElement.userName, username);
		elementType(loginPageElement.passWord, password);
		elementClick(loginPageElement.login);
		return new PFDashboardPage();
	}
}
