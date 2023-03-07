package com.jtaf.ohrm.pages;

import com.jtaf.ohrm.common.ReusableComponent;

public class LoginPage extends ReusableComponent {

	public DashboardPage doLogin() {

		elementType("userName", "admin");
		elementType("password", "admin123");
		elementClick("login");
		return new DashboardPage();
	}

	public void gotoForgotPasswordPage() {

		elementClick("forgotPasswordLink");
		elementType("fplUserName", "admin");
		elementClick("fplReset");
	}
}
