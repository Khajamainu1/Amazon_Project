package com.automatiom.placeOrder.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.baseTest.BaseTest;
import com.automation.driver.Driver;
import com.automation.pages.AmazonHomePage;

import com.automation.pages.BasePage;
import com.google.common.util.concurrent.Uninterruptibles;

public class Shoes_AutoSuggestion extends BaseTest {
	
	
	@Test
	public void autoSuggestion()
	{
		AmazonHomePage amazonHopePage = new AmazonHomePage();
		BasePage basePage = new BasePage();
		
		amazonHopePage.search("shoes");
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
		
		
		
		
		
		
		
		
		
		
		
		
		
//		basePage.visibilityOfElementLoacated(By.xpath("//div[@class='left-pane-results-container']"));
//		
//		List<WebElement> autoSuggestion =  Driver.getDriver().findElements(By.xpath("//div[@class='left-pane-results-container']/div"));
//	
//		System.out.println("Auto suggestion : " + autoSuggestion.size());
////		autoSuggestion.get(0).click();
//		
//		Driver.getDriver().findElement(By.xpath(null));
		
		
		
		
		
//		
//		for(WebElement element : autoSuggestion)
//		{
//			String arialabel = element.getAttribute("aria-label");
//			
//			
//			if(arialabel!=null)
//			{
//				System.out.println(arialabel);
//			}
//			else
//			{
//				System.out.println("aria-label not found for this element");
//			}
//		}
//		
//		autoSuggestion.get(2).click();
		
		
		
		
		
		for(WebElement elements : autoSuggestion)
		{
//			System.out.println(elements.getAttribute("aria-label"));
			
			
			
			basePage.visibilityOfElementLoacated(By.xpath("//div[@class='left-pane-results-container']"));
//			System.out.println(elements.getAttribute("aria-label"));
			
			basePage.visibilityOfElementLoacatedByElement(elements);
			
			   String ariaLabel = elements.getAttribute("aria-label");
			    if (ariaLabel != null && !ariaLabel.isEmpty()) {
			        System.out.println(ariaLabel);
			    } else {
			        System.out.println("aria-label not found or empty for this element");
			    }
		}
		
	
		

	
	
	}

}
