package com.org.selenium.base;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class Listeners implements ITestListener {
	private static final Logger logger = LogManager.getLogger(Listeners.class);

	public void onTestStart(ITestResult result) {
		logger.info("starting:::::"+result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getName()+" completed::::::::");

	}

	public void onTestFailure(ITestResult result) {
		logger.info(result.getName()+" FAILED::::::::");
		try {
			BaseFramework.getScreenShots(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
