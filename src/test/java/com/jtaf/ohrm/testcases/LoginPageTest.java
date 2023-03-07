package com.jtaf.ohrm.testcases;

import com.jtaf.ohrm.pages.DashboardPage;
import com.jtaf.ohrm.pages.LoginPage;

public class LoginPageTest {

	public static void main(String[] args) {

		LoginPage loginPage = new LoginPage();
		loginPage.doLogin();
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.doLogout();
	}
}
