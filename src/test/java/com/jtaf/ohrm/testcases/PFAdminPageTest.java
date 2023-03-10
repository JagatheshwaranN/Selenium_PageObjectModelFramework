package com.jtaf.ohrm.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.jtaf.ohrm.base.PageFactoryPage;
import com.jtaf.ohrm.common.PFReusableComponent;
import com.jtaf.ohrm.pages.PFAdminPage;
import com.jtaf.ohrm.pages.PFDashboardPage;
import com.jtaf.ohrm.pages.PFLoginPage;
import com.jtaf.ohrm.utils.TestUtil;

public class PFAdminPageTest extends PageFactoryPage {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dataFetch")
	public static void pfAdminPageTest(Hashtable<String, String> data) {

		PFLoginPage loginPage = new PFLoginPage();
		PFDashboardPage dashboardPage = loginPage.pfDoLogin(data.get("UserName"), data.get("Password"));
		PFAdminPage adminPage = dashboardPage.pfNavigateToAdminPage();
		adminPage.pfSearchUser(data.get("User"), data.get("SearchCriteria"));
	}
}
