package com.org.selenium.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.org.selenium.base.BaseFramework;
import com.org.selenium.pageresources.LandingPageElements;

public class LandingPageTest extends BaseFramework{
	WebDriver driver;
	LandingPageElements landingPage;
	
	@Test()
	public void landingPageNavigationTest() throws IOException {
		try {
			System.out.println("Title::"+landingPage.getTitle().getText());
			Assert.assertEquals(landingPage.getTitle().getText(),"FEATURED COURSES");
			Assert.assertEquals(landingPage.getNoThanksLink().getText(),"NO THANKS");
			landingPage.getNoThanksLink().click();
			
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}finally {
		//	driver.quit();
		}
	}
	
	@Test()
	public void homeNavigationBarTest() throws IOException {
		try {
			Assert.assertEquals(landingPage.getHomeLink().getText(),"HOME");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}finally {
		//	driver.quit();
		}
	}
	
	@Test()
	public void coursesNavigationBarTest() throws IOException {
		try {
			Assert.assertEquals(landingPage.getCoursesLink().getText(),"COURSES");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}finally {
		//	driver.quit();
		}
	}
	
	@Test()
	public void videosNavigationBarTest() throws IOException {
		try {
			Assert.assertEquals(landingPage.getVideosLink().getText(),"VIDEOS");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}finally {
		//	driver.quit();
		}
	}
	
	@AfterTest
	public void closeBrowsers() {
		System.out.println("executing after Test");
		driver.quit();
		driver = null;
	}
	
	@BeforeTest
	public void initialize() throws IOException {
		System.out.println("executing before Test");
		driver = initializeDriver();
		driver.get(propertyLoader().getProperty("landingPageUrl"));
		landingPage = new LandingPageElements(driver);
	}
}
