package com.jtaf.ohrm.testcases;

import org.testng.annotations.Test;

import com.jtaf.ohrm.pages.AdminPage;
import com.jtaf.ohrm.pages.DashboardPage;

public class AdminPageTest extends BaseTest {

	@Test
	public static void adminPageTest() {

		DashboardPage dashboardPage = new DashboardPage();
		AdminPage adminPage = dashboardPage.navigateToAdminPage();
		adminPage.searchUser(getDataFromPropFile("user"), getDataFromPropFile("status"));
		dashboardPage.doLogout();
	}
}
