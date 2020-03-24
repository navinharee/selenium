package com.org.selenium.pageresources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements extends BaseDriver{
	
	@FindBy(id="user_email")
	private WebElement emailAddress;
	@FindBy(id="user_password")
	private WebElement password;
	
	@FindBy(name="commit")
	private WebElement logInClick;
	
	public LoginPageElements(WebDriver driver) {
		super(driver);
	}

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogInClick() {
		return logInClick;
	}
	
	

}
