package com.automation.pages;

import java.sql.DriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.driver.Driver;

public class BasePage {
	
	//click-method
	public static void click(WebElement element, String elementName)
	{
		element.click();
		System.out.println(elementName + " : is clicked");
	}
	
	//clear-Method
	public static void clear(WebElement element, String elementName)
	{
		element.clear();
		System.out.println(elementName + " : is cleared");
	}
	
	public static void sendKeys(WebElement element, String value, String elementName)
	{
		element.sendKeys(value);
		System.out.println(value + " : is passed in the " +elementName+ " field");
	}
	
	public static void selectDropDownOptions(WebElement element, String valueToBeSelected, String elementName)
	{
		Select sc = new Select(element);
		sc.selectByVisibleText(valueToBeSelected);
		System.out.println(valueToBeSelected + " is selected in the " +elementName+ " dropdown");
		
	}
	
	public static void presenceOfElementLoacated(By by)
	{
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static void visibilityOfElementLoacated(By by)
	{
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public static void visibilityOfElementLoacatedByElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static String getText(WebElement element, String elementName)
	{
		return element.getText().trim();
		
	}
	
	
	
	

}
