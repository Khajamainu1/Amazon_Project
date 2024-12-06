package com.automation.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.driver.Driver;

public class BasePage {
	
	private static Actions action = new Actions(Driver.getDriver());
	JavascriptExecutor js =(JavascriptExecutor) Driver.getDriver();
	
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
	
	public static void moveToElement(WebElement element)
	{
		action.moveToElement(element);
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
	
	public static void elementToBeClicableWait(By by)
	{
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(by));
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
	
	public static String getAttribute(WebElement element, String value, String elementName)
	{
		return element.getAttribute(value);
		
	}
	
	public void scrollUsingJS(WebElement element, String elementName)
	{
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	// Zoom out by reducing the zoom level (e.g., 0.8 for 80% zoom)
	public void  zoomOutBrowser() {
	    
	    js.executeScript("document.body.style.zoom='80%'");
	}
	


	public void clickUsingJavaScript(WebElement element, String elementName)
	{
//		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click();", element);
		System.out.println(element + " is clicked");
	}
	
	public static void switchToTab(int tab)
	{
	Set<String> tabs = 	Driver.getDriver().getWindowHandles();
	List<String> list = new ArrayList<String>(tabs);
	
	Driver.getDriver().switchTo().window(list.get(tab));
//	presenceOfElementLoacated(By.xpath("//input[@id='add-to-cart-button']"));
	}
	
	

}
