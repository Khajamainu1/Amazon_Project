package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.driver.Driver;

public class SignInPage extends BasePage {
	
	public SignInPage()
	{
		WebDriver driver = Driver.getDriver();
		if(driver != null)
		{
			System.out.println("Driver is initialized in AmazonHomePage constructor");
			PageFactory.initElements(driver, this);
		}
		else
			throw new RuntimeException("Driver is not initiated. Please check the driver setup");
	}
	
	@FindBy(xpath="//input[@type='email']")
	WebElement txt_email;
	
	@FindBy(xpath = "//span[@id='continue']")
	WebElement btn_continue;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement txt_password;
	
	@FindBy(id = "signInSubmit")
	WebElement btn_signIn;
	
	public void enterEmailOrMobile(String value) {
		presenceOfElementLoacated(By.xpath("//label[contains(text(),'Email or mobile')]"));
		sendKeys(txt_email, value, "Email/Mobile");
	}
	
	public void clickContinue()
	{
		click(btn_continue, "Continue");
		
	}
	
	public void enterPassword(String password)
	{
		presenceOfElementLoacated(By.xpath("//label[contains(text(),'Password')]"));
		sendKeys(txt_password, password, "Password");
		
	}
	
	public void clickSignIn()
	{
		click(btn_signIn, "Sign In");
		presenceOfElementLoacated(By.xpath("//span[text()='Hello, Khaja']"));
	}

}
