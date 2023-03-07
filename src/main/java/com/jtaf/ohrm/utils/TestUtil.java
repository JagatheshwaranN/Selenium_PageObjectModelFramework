package com.jtaf.ohrm.utils;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.jtaf.ohrm.base.Page;

public class TestUtil extends Page {

	@DataProvider(name = "dataFetch")
	public static Object[][] getData(Method method) {
		return null;
	}

	@DataProvider(name = "dataFetchOld")
	public static Object[][] getDataOld(Method method) {
		return null;
	}

	public static boolean isTestRunnable(String testName, ExcelReaderUtil excel) {
		return false;
	}
}
