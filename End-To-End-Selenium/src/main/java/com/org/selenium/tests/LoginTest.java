package com.org.selenium.tests;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.selenium.base.BaseFramework;
import com.org.selenium.pageresources.HomePageElements;
import com.org.selenium.pageresources.LoginPageElements;

public class LoginTest extends BaseFramework{
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	WebDriver driver;
	HomePageElements homePage;
	LoginPageElements loginPage;
	
	@Test(dataProvider="getData")
	public void baseTest(String userName,String password,String role) {
		try {
			logger.info("LOGGING##########");
			driver.get(propertyLoader().getProperty("url"));
			homePage = new HomePageElements(driver);
			loginPage = new LoginPageElements(driver);
			homePage.getLogin().click();
			loginPage.getEmailAddress().sendKeys(userName);
			loginPage.getPassword().sendKeys(password);
			System.out.println("Role:::"+role);
			loginPage.getLogInClick().click();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}finally {
			//driver = null;
		}
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][3];
		data[0][0]="navinsourie@gmail.com";
		data[0][1]="cigna123";
		data[0][2]="restricted user";
		
		data[1][0]="vivinSourie@gmail.com";
		data[1][1]="anthem123";
		data[1][2]="power user";
		
		data[2][0]="bolder@gmail.com";
		data[2][1]="bluecross@123";
		data[2][2]="Super user";
		return data;
	}
	
	@BeforeTest
	public void initialize() throws IOException {
		System.out.println("executing before Test");
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		driver = initializeDriver();
		
	}
	
	@AfterTest
	public void closeBrowsers() {
		System.out.println("executing after Test");
		driver.quit();
		driver = null;
	}

}
