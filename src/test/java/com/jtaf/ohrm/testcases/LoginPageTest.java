package com.jtaf.ohrm.testcases;

import com.jtaf.ohrm.pages.DashboardPage;
import com.jtaf.ohrm.pages.LoginPage;

public class LoginPageTest {

	public static void main(String[] args) {

		LoginPage loginPage = new LoginPage();
		DashboardPage dashboardPage = loginPage.doLogin();
		dashboardPage.doLogout();
	}
}
