package com.automatiom.placeOrder.tests;

import org.testng.annotations.Test;

import com.automation.baseTest.BaseTest;
import com.automation.enums.ConfigProperties;
import com.automation.pages.AmazonHomePage;
import com.automation.pages.ProductPage;
import com.automation.utils.PropertyUtils;

public class TC_AddWishlistAndMovetoCart extends BaseTest {


	@Test
	public void wishlist() {

		AmazonHomePage amazonhomepage = new AmazonHomePage();
		ProductPage productpage = new ProductPage();

		amazonhomepage.signin();
		amazonhomepage.userName(PropertyUtils.getProperty(ConfigProperties.USERNAME));
		//amazonhomepage.passWord(PropertyUtils.getProperty(ConfigProperties.PASSWORD));
		amazonhomepage.passWord("Shivu@1998");
		
		amazonhomepage.search("shoes for woman");
		
		amazonhomepage.signOut();
		
		productpage.selectFirstProduct();
		
//		productpage.addWishListButton();
//		productpage.viewListButton();


	}


}
