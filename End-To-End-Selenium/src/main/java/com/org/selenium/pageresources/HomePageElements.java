package com.org.selenium.pageresources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements extends BaseDriver{
	public HomePageElements(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="a[href*='sign_in'] span")
	private WebElement login;
	public WebElement getLogin() {
		return login;
	}
	public void setLogin(WebElement login) {
		this.login = login;
	}
	
	

}
