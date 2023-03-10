package com.jtaf.ohrm.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPageElement {

	@FindBy(css = ".oxd-topbar-header-breadcrumb")
	public WebElement adminHeader;

	@FindBy(css = ".oxd-form .oxd-input.oxd-input--active")
	public WebElement adminSearchUserName;

	@FindBy(xpath = "(//div[contains(@class,'oxd-select-text--after')])[1]")
	public WebElement adminUserRoleDropDown;

	@FindBy(xpath = "//div[@role='listbox']//div[@role='option']//span")
	public List<WebElement> adminUserRoleDropDownOptions;

	@FindBy(xpath = "(//div[contains(@class,'oxd-select-text--after')])[2]")
	public WebElement adminUserStatusDropDown;

	@FindBy(xpath = "//div[@role='listbox']//div[@role='option']//span")
	public List<WebElement> adminUserStatusDropDownOptions;

	@FindBy(xpath = "//button[contains(@class,'oxd-button--secondary orangehrm-left-space')]")
	public WebElement adminSearch;

	@FindBy(css = ".oxd-table-card")
	public WebElement adminSearchResultSection;

	@FindBy(css = ".oxd-table-cell.oxd-padding-cell:nth-child(2)")
	public WebElement adminSearchResultData;

}
