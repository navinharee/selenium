package com.org.selenium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseFramework {
	private static WebDriver driver=null;
	public static WebDriver initializeDriver() throws IOException {
		
		String browserType = propertyLoader().getProperty("browser");
		if(browserType.equalsIgnoreCase(BrowserType.CHROME.toString())) {
			System.out.println("path::::"+propertyLoader().getProperty("chromedriver.path"));
			System.setProperty("webdriver.chrome.driver", propertyLoader().getProperty("chromedriver.path")+"//chromedriver");
			driver = new ChromeDriver();
		}else if(browserType.equalsIgnoreCase(BrowserType.FIREFOX.toString())) {
			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver", "//Users//navinsourie//Documents//Technology//Selenium//chromedriver");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void main(String arr[]) throws IOException {
		initializeDriver();
	}
	
	public static Properties propertyLoader() throws IOException {
		Properties pros = new Properties();
		FileInputStream f = new FileInputStream("selenium.properties");
		pros.load(f);
		return pros;
	}
	
	public static void getScreenShots(String testName) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("//Users//navinsourie//Documents//log4j//"+testName+"-screenshots.png"));
	}

}
