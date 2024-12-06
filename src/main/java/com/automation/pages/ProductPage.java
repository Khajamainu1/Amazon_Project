package com.automation.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.driver.Driver;
import com.google.common.util.concurrent.Uninterruptibles;

public class ProductPage extends BasePage {
	
	public void ProductPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
//	@FindBy(xpath = "(//span[contains(text(),'ETPU Athleisure Shoes for Women')])[1]")
//	WebElement btn_shoes;
	
//	@FindBy(xpath = "(//div[@data-asin='B0DHKJFLTX']//child::div[2]//following::div[6]//following::a//span[contains(text(),'ETPU Athleisure Shoes')])[1]")
//	WebElement btn_shoes1;
//	
//	@FindBy(xpath = "//div[@data-cel-widget='search_result_2']")
//	WebElement btn_shoes;
	
	@FindBy(xpath = "//h2[text()='Results']//following::div[10]//span//a")
	WebElement btn_shoes;
	
//	public void shoes() {
//		//scrollDown(btn_shoes);
//		presenceOfElementLoacated(By.xpath("//h2[text()='Results' ]"));
//		
//		click(btn_shoes, "shoes select");
//		Uninterruptibles.sleepUninterruptibly(10,TimeUnit.SECONDS);
//	}
	
	public void selectFirstProduct()
	{
		zoomOutBrowser();
		presenceOfElementLoacated(By.xpath("//h2[text()='Results']"));
		click(btn_shoes, "First Product");
		
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
		
	}
	

//	@FindBy(xpath="//button[text()='Add to cart']")
//	WebElement btn_productbutton;
//	
//	@FindBy(xpath = "//input[@title='Add to Wish List']")
//	WebElement btn_AddWishList;
//	
//	public void productButton() {
//		//presenceOfElementLoacated(By.xpath("(//span[contains(text(),'boAt Airdopes 311 ')])[2]"));
//		presenceOfElementLoacated(By.xpath("//span[contains(text(),'boAt Rockerz 255')]"));
//		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
//		clickUsingJavaScriptExecutor(btn_productbutton, "link");
//	}
//	
//	@FindBy(id="huc-view-your-list-button")
//	WebElement btn_viewyourlist;
//	
//	public void addWishListButton() {
//		click(btn_AddWishList, "wish list button");
//	}
//	public void viewListButton() {
//		click(btn_AddWishList, "view list button");
	
//}
}

