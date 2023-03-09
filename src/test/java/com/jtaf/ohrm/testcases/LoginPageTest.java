package com.jtaf.ohrm.testcases;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.jtaf.ohrm.pages.LoginPage;
import com.jtaf.ohrm.utils.TestUtil;

public class LoginPageTest extends BaseTest {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dataFetch")
	public static void loginPageTest(Hashtable<String, String> data) {

		Class<LoginPageTest> classObj = LoginPageTest.class;
		Method[] methods = classObj.getMethods();
		if (!TestUtil.isTestRunnable(methods[0].getName(), excelReaderUtil)) {
			throw new SkipException("Skipping the Test " + methods[0].getName() + " as the RunMode is set to N");
		}
		if (!data.get("RunMode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the Test Case as the RunMode for the Data is set to N");
		}
		LoginPage loginPage = new LoginPage();
		loginPage.doLogin(data.get("UserName"), data.get("Password"));
	}
}
