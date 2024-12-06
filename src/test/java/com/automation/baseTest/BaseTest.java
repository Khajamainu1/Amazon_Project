package com.automation.baseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.driver.Driver;

public class BaseTest {
	
	@BeforeMethod
	public void setUp()
	{
		Driver.initDriver();
	}
	
//	@AfterMethod
//	public void tearDown()
//	{
//		Driver.quitDriver();
//	}

}
