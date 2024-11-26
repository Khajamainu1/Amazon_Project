package com.automation.baseTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.automation.driver.Driver;

public class BaseTest {
	
	@BeforeClass
	public void setUp()
	{
		System.out.println("Initializing WebDriver in BaseTest");
		Driver.initDriver();
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("Quitting WebDriver in BaseTest");
		Driver.quitDriver();
	}

}
