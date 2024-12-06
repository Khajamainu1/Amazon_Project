package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.driver.Driver;
import com.google.common.util.concurrent.Uninterruptibles;

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
    
    @FindBy(xpath="//span[text()='Account & Lists']")
    WebElement signIn;
    
    @FindBy(id = "nav-search-submit-button")
    WebElement btn_Search;
    
    @FindBy(xpath = "//a[@id='nav-cart']")
    WebElement logo_cart;
    
    
    
    public void search(String value) {
        sendKeys(searchBox, value, "Search Box");
        click(btn_Search, "Search");
//        presenceOfElementLoacated(By.xpath("//span[text()='" + value + "']"));
        presenceOfElementLoacated(By.xpath("//span[text()='\"" + value + "\"']"));
    }
    
    public void clickSignIn()
    {
    	
    	Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
    	click(signIn, "SignIn");
    }
    
    public void clickCartLogo()
    {
    	click(logo_cart, "Cart logo");
    }
    
}
