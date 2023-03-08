package com.jtaf.ohrm.testcases;

import org.testng.annotations.AfterSuite;

import com.jtaf.ohrm.base.Page;

public class BaseTest extends Page {

	@AfterSuite
	public void tearDown() {
		Page.closeBrowser();
	}
}
