package com.automation.pages;

import java.time.Duration;
<<<<<<< HEAD
import java.util.concurrent.TimeUnit;
=======
>>>>>>> 5d929959cd480f74034e18c821af2e8d10235b84

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
<<<<<<< HEAD
	}

	//   public  AmazonHomePage(WebDriver driver)
	//   {
	//	this.driver=driver;
	//	PageFactory.initElements(driver, this);
	//   }

	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;

	@FindBy(id="nav-search-submit-button")
	WebElement btn_search;



	public void search(String value) {
		sendKeys(searchBox, value, "Search Box");
		click(btn_search, "search button");
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

	}

//	@FindBy(xpath="//div[@id='nav-al-signin']//child::div//a//span")
//	WebElement btn_firstSignin;
	
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	WebElement btn_firstSignin;

	@FindBy(xpath="//input[@type='email']")
	WebElement txt_username;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement btn_continue;

	@FindBy(xpath="//input[@name='password']")
	WebElement txt_password;

	@FindBy(id="signInSubmit")
	WebElement btn_signin;

	public void signin() {
		presenceOfElementLoacated(By.xpath("//a[@id='nav-link-accountList']"));
		click(btn_firstSignin, "first sign button to click");	
	}


	public void userName(String username) {

		sendKeys(txt_username, username, "user name");
		click(btn_continue, "continue button");
	}



	public void passWord(String password) {
		sendKeys(txt_password, password, "password");
		click(btn_signin, "signin button");
	}

	@FindBy(xpath="//span[text()='Sign Out']")
	WebElement btn_signout;
	
	public void signOut() {
		click(btn_signout, "signout");
	}

=======
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
    
>>>>>>> 5d929959cd480f74034e18c821af2e8d10235b84
}
