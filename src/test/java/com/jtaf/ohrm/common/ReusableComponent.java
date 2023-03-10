package com.jtaf.ohrm.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.jtaf.ohrm.base.Page;

public class ReusableComponent extends Page {

	public static WebElement generateWebElement(String key) throws Exception {
		String locatorSplit = getDataFromPropFile(key);
		String locatorType = locatorSplit.split(":")[0];
		String locatorValue = locatorSplit.split(":")[1];
		System.out.println("locatorType  ==> " + locatorType);
		System.out.println("locatorValue ==> " + locatorValue);
		if (locatorType.equalsIgnoreCase("css"))
			return driver.findElement(By.cssSelector(locatorValue));
		if (locatorType.equalsIgnoreCase("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		throw new Exception("Unknown Locator Type : " + locatorType);
	}

	public static List<WebElement> generateWebElements(String key) throws Exception {
		String locatorSplit = getDataFromPropFile(key);
		String locatorType = locatorSplit.split(":")[0];
		String locatorValue = locatorSplit.split(":")[1];
		if (locatorType.equalsIgnoreCase("css"))
			return driver.findElements(By.cssSelector(locatorValue));
		if (locatorType.equalsIgnoreCase("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		throw new Exception("Unknown Locator Type : " + locatorType);
	}

	public static boolean isElementPresent(String key) {

		try {
			if (key != null) {
				generateWebElement(key);
				test.log(Status.INFO, key + " is present on the page");
			}
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static void elementClick(String key) {

		try {
			if (key != null) {
				generateWebElement(key).click();
				test.log(Status.INFO, "Clicked on the " + key);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void elementType(String key, String value) {

		try {
			if (key != null) {
				generateWebElement(key).sendKeys(value);
				test.log(Status.INFO, "Typed into " + key + " with value as " + value);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void elementSelect(String key, String value) {

		try {
			if (key != null) {
				Select select = new Select(driver.findElement(By.cssSelector(getDataFromPropFile(key))));
				select.selectByVisibleText(value);
				test.log(Status.INFO, "Selected " + value + " in the dropdown " + key);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void elementSelect(String key, int index) {

		try {
			if (key != null) {
				Select select = new Select(driver.findElement(By.cssSelector(getDataFromPropFile(key))));
				select.selectByIndex(index);
				test.log(Status.INFO, "Selected " + index + " in the dropdown " + key);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void elementSelect(String key1, String key2, String value) {

		try {
			generateWebElement(key1).click();
			List<WebElement> options = generateWebElements(key2);
			boolean flag = false;
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(value)) {
					flag = true;
					option.click();
					test.log(Status.INFO, "Selected " + value + " in the dropdown " + key1);
					break;
				}
			}
			if (flag == false) {
				System.out.println(flag + "-" + value + " option not found on the " + key1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void verifyEquals(String actual, String expected) {

	}

}
