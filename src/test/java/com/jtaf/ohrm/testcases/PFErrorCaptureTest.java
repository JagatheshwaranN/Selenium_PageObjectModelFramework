package com.jtaf.ohrm.testcases;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.jtaf.ohrm.base.PageFactoryPage;
import com.jtaf.ohrm.pages.PFDashboardPage;
import com.jtaf.ohrm.pages.PFLoginPage;
import com.jtaf.ohrm.utils.ErrorCapture;
import com.jtaf.ohrm.utils.TestUtil;

public class PFErrorCaptureTest extends PageFactoryPage {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dataFetch")
	public static void pfErrorCaptureTest(Hashtable<String, String> data) {

		Class<PFErrorCaptureTest> classObj = PFErrorCaptureTest.class;
		Method[] methods = classObj.getMethods();
		if (!TestUtil.pfIsTestRunnable(methods[0].getName(), excelReaderUtil)) {
			throw new SkipException("Skipping the Test " + methods[0].getName() + " as the RunMode is set to N");
		}
		if (!data.get("RunMode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the Test Case as the RunMode for the Data is set to N");
		}

		PFLoginPage loginPage = new PFLoginPage();
		PFDashboardPage dashboardPage = loginPage.pfDoLogin(data.get("UserName"), data.get("Password"));
		ErrorCapture.verifyEquals(dashboardPage.getQuickLaunchCards().size(), 6);
		ErrorCapture.verifyEquals(dashboardPage.getQuickLaunchCards().size(), 7);
		ErrorCapture.verifyEquals(dashboardPage.getQuickLaunchCards().size(), 8);
	}
}
