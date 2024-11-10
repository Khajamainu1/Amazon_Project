package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.driver.Driver;

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
}
