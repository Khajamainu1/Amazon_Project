package com.automation.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.automation.enums.ConfigProperties;
import com.automation.utils.PropertyUtils;
import com.google.common.util.concurrent.Uninterruptibles;

public class Driver {
	
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
//	private static WebDriver driver;
	public static WebDriver initDriver()
	{
		  if (driver.get() == null)
		  { 
	            String browserType = PropertyUtils.getProperty(ConfigProperties.BROWSER);

	            if (browserType == null || browserType.isEmpty()) 
	            {
	                throw new IllegalArgumentException("Browser is not specified in the property utils");
	            }
		
		switch (browserType.toLowerCase())
		{
		case  "chrome" :
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
//			options.addArguments("--start-maximized");
			options.addArguments("--disable-extensions");
			
			 driver.set(new ChromeDriver(options));
			break;
			
		case  "firefox" :
			FirefoxOptions options1 = new FirefoxOptions();
			options1.addArguments("--start-maximized");
//			options1.addArguments("--start-maximized");
			options1.addArguments("--disable-extensions");
			
			 driver.set(new FirefoxDriver(options1));
			break;

		default:
			throw new IllegalArgumentException("Browser type not supported");
		}
		
		WebDriver driverInstance = driver.get();
		driverInstance.get(PropertyUtils.getProperty(ConfigProperties.URL));
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

		 }
		return driver.get();
	}
	
	public static void quitDriver()
	{
		if(driver.get()!=null)
		{
		driver.get().quit();
		driver = null;
		}
		
		
	}
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}

}
