package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.driver.Driver;

public class ShoppingCartPage extends BasePage {
	
	public ShoppingCartPage()
	{ 
		WebDriver driver = Driver.getDriver();
		if (driver != null)
		{ 
			System.out.println("Driver is initialized in ShoppingCartPage constructor"); 
		PageFactory.initElements(driver, this);
		} 
		else { throw new RuntimeException("Driver is not initialized. Please check driver setup."); } 
		}
	
	@FindBy(xpath = "//div[@class='a-declarative' and @role='spinbutton']")
	WebElement product_count;
	
	@FindBy(xpath = "(//button[@class='a-declarative'])[1]")
	WebElement btn_minus;
	
	@FindBy(xpath  = "//input[@name='proceedToRetailCheckout']")
	WebElement btn_proceed_To_Buy;
	
	@FindBy(xpath = "//div[@data-name='Active Items']/div/div[4]/descendant::label/input[@aria-label='Item in shopping cart']")
	WebElement checkBox;
	
	@FindBy(xpath = "//span[@id='sw-gtc']/span/a")
	WebElement btn_goToCart;
	
	public int getProductCount()
	{
		String value = "aria-valuetext";
		return Integer.valueOf(getAttribute(product_count, value, "Product Counts"));
	}
	
	public void clickMinus()
	{
		click(btn_minus, "Minus");
	}
	
	public void clickProceedToBuy()
	{
		elementToBeClicableWait(By.xpath("//input[@name='proceedToRetailCheckout']"));
		click(btn_proceed_To_Buy, "Proceed to buy");
	}
	
	public void clickGoToCart()
	{
		click(btn_goToCart, "Go to cart");
	}

}
