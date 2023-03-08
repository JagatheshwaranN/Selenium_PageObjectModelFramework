package com.jtaf.ohrm.testcases;

import org.testng.annotations.Test;

import com.jtaf.ohrm.pages.LoginPage;

public class LoginPageTest extends BaseTest {

	@Test
	public static void loginPageTest() {

		LoginPage loginPage = new LoginPage();
		loginPage.doLogin(getDataFromPropFile("username"), getDataFromPropFile("password"));
		// dashboardPage.doLogout();
	}
}
