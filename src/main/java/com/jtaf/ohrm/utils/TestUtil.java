package com.jtaf.ohrm.utils;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.jtaf.ohrm.base.Page;
import com.jtaf.ohrm.config.Constants;

public class TestUtil extends Page {

	/**
	 * PageObjectModel basics code starts here.
	 */
	@DataProvider(name = "dataFetch")
	public static Object[][] getData(Method method) {

		String sheetName = method.getName();
		int totalRows = excelReaderUtil.getRowCount(sheetName);
		int totalCols = excelReaderUtil.getColumnCount(sheetName);
		Object[][] data = new Object[totalRows - 1][1];
		Hashtable<String, String> table = null;
		for (int rowNum = 2; rowNum <= totalRows; rowNum++) {
			table = new Hashtable<String, String>();
			for (int colNum = 0; colNum < totalCols; colNum++) {
				table.put(excelReaderUtil.getCellData(sheetName, colNum, 1),
						excelReaderUtil.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}
		}
		return data;
	}

	public static boolean isTestRunnable(String testName, ExcelReaderUtil excel) {

		String sheetName = getDataFromPropFile("suiteSheet");
		String testCaseColumn = getDataFromPropFile("testColumn");
		String runTypeColumn = getDataFromPropFile("runColumn");
		int rows = excel.getRowCount(sheetName);
		for (int row = 2; row <= rows; row++) {
			String testCase = excel.getCellData(sheetName, testCaseColumn, row);
			if (testCase.equalsIgnoreCase(testName)) {
				String runMode = excel.getCellData(sheetName, runTypeColumn, row);
				if (runMode.equalsIgnoreCase("Y")) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * PageFactory code starts here.
	 */
	public static boolean pfIsTestRunnable(String testName, ExcelReaderUtil excel) {

		String sheetName = Constants.suiteSheet;
		String testCaseColumn = Constants.testColumn;
		String runTypeColumn = Constants.runColumn;
		int rows = excel.getRowCount(sheetName);
		for (int row = 2; row <= rows; row++) {
			String testCase = excel.getCellData(sheetName, testCaseColumn, row);
			if (testCase.equalsIgnoreCase(testName)) {
				String runMode = excel.getCellData(sheetName, runTypeColumn, row);
				if (runMode.equalsIgnoreCase("Y")) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public static void waitForSomeTime() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
