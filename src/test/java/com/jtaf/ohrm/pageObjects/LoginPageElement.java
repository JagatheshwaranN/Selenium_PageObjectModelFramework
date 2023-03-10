package com.jtaf.ohrm.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElement {

	@FindBy(xpath = "//input[@name='username']")
	public WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement passWord;

	@FindBy(xpath = "//button[contains(@class,'orangehrm-login-button')]")
	public WebElement login;

	@FindBy(xpath = "//p[contains(@class,'login-forgot-header')]")
	public WebElement forgotPasswordLink;

	@FindBy(xpath = "//input[@name='username']")
	public WebElement fplUserName;

	@FindBy(xpath = "//button[contains(@class,'orangehrm-forgot-password-button--reset')]")
	public WebElement fplReset;

}
