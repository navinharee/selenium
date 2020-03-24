package com.org.selenium.pageresources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseDriver {
	private static WebDriver driver = null;

	public BaseDriver(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public BaseDriver() {
	}
	
	
	

}
