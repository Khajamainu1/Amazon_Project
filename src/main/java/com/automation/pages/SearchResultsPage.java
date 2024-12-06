package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.driver.Driver;
import com.google.common.util.concurrent.Uninterruptibles;

public class SearchResultsPage extends BasePage{
	
	public SearchResultsPage()
	{
		WebDriver driver = Driver.getDriver();
		if(driver != null)
		{
			System.out.println("Driver is initiated in ResultsPage Constructor");
			PageFactory.initElements(driver, this);
		}
		else
			throw new RuntimeException("Driver is not initiated. Please check the driver setup");
	}
	
//	@FindBy(xpath = "//h2[text()='Results']/following::div[@data-index='3']")
//	WebElement first_product;
	
	@FindBy(xpath = "//h2[text()='Results']/following::div[@data-index='3']//span/div/div/div[2]/child::div[2]/child::h2/a")
	WebElement first_product;
	
	
	//h2[text()='Results']/following::div[@data-index='3']/child::div/div/div/div/span/div/div/div
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement btn_addToCart;
	
	public void selectFirstProduct()
	{
		zoomOutBrowser();
		presenceOfElementLoacated(By.xpath("//h2[text()='Results']"));
		clickUsingJavaScript(first_product, "First Product");
		
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
		
	}
	
	public void clickAddToCart()
	{
		click(btn_addToCart, "Add To Cart");
		presenceOfElementLoacated(By.xpath("//h1[contains(text(),'Added to cart')]"));
		
	}

}
