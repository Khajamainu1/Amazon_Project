package com.automation.listners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.driver.Driver;
import com.automation.reports.ExtentLogger;
import com.automation.reports.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ExtentReportListner implements ITestListener, ISuiteListener {
	
	
	private ExtentReports extentReports = ExtentReportManager.getInstance();
	private ExtentTest extentTest = ExtentReportManager.getExtentTest();

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getDescription();
		if(testName==null || testName.isEmpty())
		{
			testName=result.getMethod().getMethodName();
		}
	
	extentTest=	extentReports.createTest(testName);
	ExtentReportManager.setExtentTest(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(extentTest!=null)
		{
		ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed");
		ExtentLogger.info(result.getMethod().getMethodName() + " is completed successfully");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		if(extentTest!=null)
		{
			 String base64Screenshot = getBase64Image(Driver.getDriver());
	            extentTest.fail(result.getMethod().getMethodName() + " failed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
	           extentTest.fail(result.getThrowable().toString());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
	    extentReports.flush();
	    try {
	        String reportPath = ExtentReportManager.getReportPath();
	        if (reportPath != null && new File(reportPath).exists()) {
	            Desktop.getDesktop().browse(new File(reportPath).toURI());
	        } else {
	            System.out.println("Report file not found at: " + reportPath);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
//		extentReports.flush(); try {
//			// Adjusting the path to match the dynamically generated report file 
//			File reportFile = new File("target/reports/");
//			if (reportFile.exists() && reportFile.isDirectory()) 
//			{ 
//				for (File file : reportFile.listFiles()) 
//				{ 
//					if (file.getName().startsWith("ExtentReport_"))
//					{ 
//						Desktop.getDesktop().browse(file.toURI()); 
//						break;
//						}
//					}
//				}
//			} catch (IOException e) { e.printStackTrace(); 
//						}
		}
	
	
	 public static String getBase64Image(WebDriver driver) {
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	    }
	 
	 

	
	
	

}
