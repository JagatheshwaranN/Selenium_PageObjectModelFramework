package com.jtaf.ohrm.pages;

import org.openqa.selenium.support.PageFactory;

import com.jtaf.ohrm.common.PFReusableComponent;
import com.jtaf.ohrm.common.ReusableComponent;
import com.jtaf.ohrm.pageObjects.LoginPageElement;

public class LoginPage extends ReusableComponent {

	// PageFactory related code
	public LoginPageElement loginPageElement;

	public LoginPage() {

		this.loginPageElement = new LoginPageElement();
		PageFactory.initElements(driver, this.loginPageElement);
	}

	// PageObjectModel basics code
	public DashboardPage doLogin(String username, String password) {

		elementType("userName", username);
		elementType("passWord", password);
		elementClick("login");
		return new DashboardPage();
	}

	// PageObjectModel basics code
	public void gotoForgotPasswordPage() {

		elementClick("forgotPasswordLink");
		elementType("fplUserName", "admin");
		elementClick("fplReset");
	}

	// PageFactory related code
	public DashboardPage pfDoLogin(String username, String password) {

		PFReusableComponent.elementType(loginPageElement.userName, username);
		PFReusableComponent.elementType(loginPageElement.passWord, password);
		PFReusableComponent.elementClick(loginPageElement.login);
		return new DashboardPage();
	}
}
