package com.jtaf.ohrm.common;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import com.jtaf.ohrm.base.PageFactoryPage;

public class PFReusableComponent extends PageFactoryPage {

	public static boolean isElementPresent(WebElement element) {

		try {
			if (element != null) {
				test.log(Status.INFO, element + " is present on the page");
			}
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static void elementClick(WebElement element) {

		try {
			if (element != null) {
				element.click();
				test.log(Status.INFO, "Clicked on the " + element);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void elementType(WebElement element, String value) {

		try {
			if (element != null) {
				element.sendKeys(value);
				test.log(Status.INFO, "Typed into " + element + " with value as " + value);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void elementSelect(WebElement element, String value) {

		try {
			if (element != null) {
				Select select = new Select(element);
				select.selectByVisibleText(value);
				test.log(Status.INFO, "Selected " + value + " in the dropdown " + element);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void elementSelect(WebElement element, int index) {

		try {
			if (element != null) {
				Select select = new Select(element);
				select.selectByIndex(index);
				test.log(Status.INFO, "Selected " + index + " in the dropdown " + element);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void elementSelect(WebElement element1, List<WebElement> element2, String value) {

		try {
			element1.click();
			List<WebElement> options = element2;
			boolean flag = false;
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(value)) {
					flag = true;
					option.click();
					test.log(Status.INFO, "Selected " + value + " in the dropdown " + element1);
					break;
				}
			}
			if (flag == false) {
				System.out.println(flag + "-" + value + " option not found on the " + element1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
