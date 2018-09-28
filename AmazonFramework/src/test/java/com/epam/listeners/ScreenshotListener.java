/**
 * 
 */
package com.epam.listeners;

import static com.epam.base.TestBase.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author Farhaan_Shaik
 *
 */
public class ScreenshotListener implements ITestListener {
	final static Logger logger = Logger.getLogger(ScreenshotListener.class);
	private WebDriver driver;
	private String filePath = ("C:\\Users\\Farhaan_Shaik\\eclipse-workspace\\AmazonFramework\\target\\Screenshots\\screenshot.png");
	private File file;
	public ScreenshotListener() {
		if(file == null) {
			file = new File(filePath); 
		}
	}
	public void onTestFailure(ITestResult result) {
		logger.error("Test failed : "+ result.getName());
		driver = getDriver();
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(filePath);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		logger.info("Test started : "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Test is passed : "+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Test Skipped : "+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.info("Test failed but with success percentage : "+result.getName());
		
	}

	public void onStart(ITestContext context) {
		logger.info("Test context started : "+context.getName());
		
	}

	public void onFinish(ITestContext context) {
		logger.info("Test context finished : "+context.getName());
	}
}
