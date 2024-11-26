package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.driver.Driver;

public class AmazonHomePage extends BasePage {
	
	
//    public AmazonHomePage() {
//        PageFactory.initElements(Driver.getDriver(), this);
//    }
	
	public AmazonHomePage()
	{ 
		WebDriver driver = Driver.getDriver();
		if (driver != null)
		{ 
			System.out.println("Driver is initialized in AmazonHomePage constructor"); 
		PageFactory.initElements(driver, this);
		} 
		else { throw new RuntimeException("Driver is not initialized. Please check driver setup."); } 
		}
    
//   public  AmazonHomePage(WebDriver driver)
//   {
//	this.driver=driver;
//	PageFactory.initElements(driver, this);
//   }
   
    @FindBy(xpath="//input[@id='twotabsearchtextbox']")
    private WebElement searchBox;
    
    public void search(String value) {
        sendKeys(searchBox, value, "Search Box");
    }
}
