package com.automatiom.placeOrder.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.driver.Driver;
import com.automation.pages.AmazonHomePage;

import com.automation.pages.BasePage;
import com.google.common.util.concurrent.Uninterruptibles;

public class Shoes_AutoSuggestion_1 {

	@Test
	public void test()
	{
	
		AmazonHomePage amazonHopePage = new AmazonHomePage();
	BasePage basePage = new BasePage();
	
	amazonHopePage.search("shoes");
	Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
	
	BasePage.visibilityOfElementLoacated(By.xpath("//div[@class='left-pane-results-container']"));
	
	List<WebElement> autoSuggestion =  Driver.getDriver().findElements(By.xpath("//div[@class='left-pane-results-container']/div"));

	System.out.println("Auto suggestion : " + autoSuggestion.size());
//	autoSuggestion.get(0).click();
		
		
	
	
	
}
	
}
