package com.automation.reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	private static ExtentReports extentReport;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	  private static String reportPath;
	
	public static ExtentReports getInstance()
	{
		 if (extentReport == null) {
	            extentReport = new ExtentReports();

	            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	            reportPath = System.getProperty("user.dir") + "/target/reports/ExtentReport" + timestamp + ".html";

	            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
	            extentReport.attachReporter(extentSparkReporter);
	        }
	        return extentReport;
		
	}
	
	
		public static void setExtentTest(ExtentTest testName)
		{
			extentTest.set(testName);
		}
		
		public static ExtentTest getExtentTest()
		{
			return extentTest.get();
		}
	
	    public static String getReportPath() {
	        return reportPath;
	    }
		

}
