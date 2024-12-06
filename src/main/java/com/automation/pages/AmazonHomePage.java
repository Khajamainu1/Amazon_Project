package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.driver.Driver;
import com.automation.enums.ConfigProperties;
import com.automation.utils.PropertyUtils;
import com.google.common.util.concurrent.Uninterruptibles;

public class AmazonHomePage extends BasePage {
    
    // Constructor for initializing elements with PageFactory
    public AmazonHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    
    @FindBy(xpath="//input[@id='twotabsearchtextbox']")
    private WebElement searchBox;
    
    public void search(String value) {
        sendKeys(searchBox, value, "Search Box");
        
    }
                
     @FindBy(xpath ="//span[text()='Hello, sign in']")
     private WebElement Signin;
     
     public void signin(){
    	presenceOfElementLoacated(By.xpath("//span[text()='Hello, sign in']"));
		click(Signin, "signin");
     }
		
		
		//input[@id='ap_email']
		
		 @FindBy(xpath ="//input[@id='ap_email']")
	      WebElement email;
		 
		 @FindBy(xpath ="//input[@id='continue']")
	      WebElement cont;
		 
		 public void Useremail()
		 {
		    	presenceOfElementLoacated(By.xpath("//input[@id='ap_email']"));
		    	sendKeys(email, PropertyUtils.getProperty(ConfigProperties.MOBILE), "email");
				Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
		    	presenceOfElementLoacated(By.xpath("//input[@id='ap_email']"));
		    	//Driver.getDriver().findElement(By.xpath("//input[@id='continue']")).click();
		    	click(cont, "continueclicked");
		    	
		 }
		 
		 
		 @FindBy(xpath="//input[@id='ap_password']")
		 WebElement password;
		 @FindBy(xpath="//input[@id='signInSubmit']")
		 WebElement signin_btn;
		 
		 public void password()
		 {
		    	presenceOfElementLoacated(By.xpath("//input[@id='ap_password']"));
		    	sendKeys(password,PropertyUtils.getProperty(ConfigProperties.PASSWORD), "password");
				Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

		    	click(signin_btn,"signin");

		 }

		 		 
		 @FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
		 WebElement acc_det;
		 
		 public void account()
		 {
			 presenceOfElementLoacated(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
			 click(acc_det, "acct-click");
		 }
		 
		@FindBy(xpath = "//span[text()='Edit login, name, and mobile number']")
		WebElement Login_security;
		public void security()
		{
			 presenceOfElementLoacated(By.xpath("//span[text()='Edit login, name, and mobile number']"));
			 click(Login_security, "Login_sec");
		}
		
		//span[@id='NAME_BUTTON']
		@FindBy(xpath ="//span[@id='NAME_BUTTON']")
		WebElement edit_name;
		public void EditName()
		{
			presenceOfElementLoacated(By.xpath("//span[@id='NAME_BUTTON']"));
			click(edit_name,"editclick");

		}
		
		//input[@id='ap_customer_name']
		@FindBy(xpath="//input[@id='ap_customer_name']")
		WebElement cust_name;
		
		//input[@id='cnep_1C_submit_button']
		@FindBy(xpath = "//input[@id='cnep_1C_submit_button']")
		WebElement save_name;
		public void updateName(String name1)
		{
			presenceOfElementLoacated(By.xpath("//input[@id='ap_customer_name']"));
			clear(cust_name,"clear_name");
			Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
			sendKeys(cust_name, name1,"Cust_name");
			Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
			presenceOfElementLoacated(By.xpath("//input[@id='cnep_1C_submit_button']"));
			click(save_name, "save name");

		}	
		
		@FindBy(xpath ="//span[@id='NAME_SUBTITLE']")
		WebElement name2;
		public String getname()
		{
			presenceOfElementLoacated(By.xpath("//span[@id='NAME_SUBTITLE']"));
			return getText(name2, "name").trim();
		}
		 
		//div[@id='SUCCESS_MESSAGES']/div[contains(@class,'a-alert-container')]/div[normalize-space()='Name updated.']
	
        @FindBy(xpath ="//div[@id='SUCCESS_MESSAGES']/div[contains(@class,'a-alert-container')]/div[normalize-space()='Name updated.']" )
        WebElement response;
        public String getResponse()
        {
			presenceOfElementLoacated(By.xpath("//div[@id='SUCCESS_MESSAGES']/div[contains(@class,'a-alert-container')]/div[normalize-space()='Name updated.']"));
            return  getText(response, "response").trim();
        }
        
    
}
