package com.jtaf.ohrm.pages;

import com.jtaf.ohrm.common.ReusableComponent;

public class LoginPage extends ReusableComponent {

	public DashboardPage doLogin(String username, String password) {

		elementType("userName", username);
		elementType("passWord", password);
		elementClick("login");
		return new DashboardPage();
	}

	public void gotoForgotPasswordPage() {

		elementClick("forgotPasswordLink");
		elementType("fplUserName", "admin");
		elementClick("fplReset");
	}
}
