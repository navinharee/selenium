package com.org.selenium.pageresources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPageElements extends BaseDriver {
	
	@FindBy(xpath="//div[@class='text-center']/h2")
	private WebElement title;
	
	@FindBy(xpath="//button[text()='NO THANKS']")
	private WebElement noThanksLink;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homeLink;
	
	@FindBy(xpath="//a[text()='Courses']")
	private WebElement coursesLink;
	
	@FindBy(xpath="//a[text()='Videos']")
	private WebElement videosLink;
	
	

	public LandingPageElements(WebDriver driver) {
		super(driver);
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getNoThanksLink() {
		return noThanksLink;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getCoursesLink() {
		return coursesLink;
	}

	public WebElement getVideosLink() {
		return videosLink;
	}
	
	
}
