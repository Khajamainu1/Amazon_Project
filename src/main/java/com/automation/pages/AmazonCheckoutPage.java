package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.driver.Driver;

public class AmazonCheckoutPage extends BasePage{

	
	public AmazonCheckoutPage()
	{ 
		WebDriver driver = Driver.getDriver();
		if (driver != null)
		{ 
			System.out.println("Driver is initialized in AmazonHomePage constructor"); 
		PageFactory.initElements(driver, this);
		} 
		else { throw new RuntimeException("Driver is not initialized. Please check driver setup."); } 
		}
	
	
	@FindBy(xpath = "(//input[@class='a-button-input'])[6]")
	WebElement btn_address;
	
	public void clickUseThisAddressBtn()
	{
		click(btn_address, "Address Button");
		presenceOfElementLoacated(By.xpath("//li[text()='Khaja mohinuddin']"));
	}
}
