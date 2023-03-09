package com.jtaf.ohrm.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.jtaf.ohrm.pages.AdminPage;
import com.jtaf.ohrm.pages.DashboardPage;
import com.jtaf.ohrm.utils.TestUtil;

public class AdminPageTest extends BaseTest {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dataFetch")
	public static void adminPageTest(Hashtable<String, String> data) {

		DashboardPage dashboardPage = new DashboardPage();
		AdminPage adminPage = dashboardPage.navigateToAdminPage();
		adminPage.searchUser(data.get("User"), data.get("SearchCriteria"));
		dashboardPage.doLogout();
	}
}
