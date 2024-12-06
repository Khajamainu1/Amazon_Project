package com.automatiom.placeOrder.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.baseTest.BaseTest;
import com.automation.driver.Driver;
import com.automation.enums.ConfigProperties;
import com.automation.pages.AmazonCheckoutPage;
import com.automation.pages.AmazonHomePage;
import com.automation.pages.BasePage;
import com.automation.pages.SearchResultsPage;
import com.automation.pages.ShoppingCartPage;
import com.automation.pages.SignInPage;
import com.automation.utils.PropertyUtils;

public class Place_Cancel_Order extends BaseTest {
	
	@Test
	public void place_CalncelOrder()
	{
	
	AmazonHomePage amazonHomePage = new AmazonHomePage();
	SignInPage signInPage = new SignInPage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();
	ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
	AmazonCheckoutPage amazonCheckoutPage = new AmazonCheckoutPage();
	BasePage basePage =new BasePage();
	
	amazonHomePage.clickSignIn();
	signInPage.enterEmailOrMobile(PropertyUtils.getProperty(ConfigProperties.EMAILMOBILE));
	signInPage.clickContinue();
	signInPage.enterPassword(PropertyUtils.getProperty(ConfigProperties.PASSWORD));
	signInPage.clickSignIn();
	amazonHomePage.search("sparx shoes for man");
	searchResultsPage.selectFirstProduct();
	
	BasePage.switchToTab(1);
	searchResultsPage.clickAddToCart();
//	shoppingCartPage.clickProceedToBuy();
//	amazonCheckoutPage.clickUseThisAddressBtn();
	
	shoppingCartPage.clickGoToCart();
//	basePage.elementToBeClicableWait(By.xpath("//div[@data-name='Active Items']/div/div[4]/descendant::label/input[@aria-label='Item in shopping cart']"));
	
	basePage.presenceOfElementLoacated(By.xpath("//div[@data-name='Active Items']/div/div[4]/descendant::label/input[@aria-label='Item in shopping cart']"));
  List<WebElement> checkboxes =	Driver.getDriver().findElements(By.xpath("//div[@data-name='Active Items']/div/div[4]/descendant::label/input[@aria-label='Item in shopping cart']"));
	for(int i=0; i<checkboxes.size(); i++)
	{
		WebElement checkbox= checkboxes.get(i);
		if(i==0)
		{
		if(!checkbox.isSelected())
		{
			basePage.clickUsingJavaScript(checkbox, "checkbox");
			
		}
		else
		if(checkbox.isSelected())
			{
			    basePage.elementToBeClicableWait(By.xpath("//div[@data-name='Active Items']/div/div[4]/descendant::label/input[@aria-label='Item in shopping cart']"));
				checkbox.click();
			}
	}
	
//	
//	int productCount = shoppingCartPage.getProductCount();
//	
//	
//	while(productCount>1)
//	{
//		shoppingCartPage.clickMinus();
//	}
//	
//	shoppingCartPage.clickProceedToBuy();
	

}
	}
}