package com.automatiom.placeOrder.tests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.baseTest.BaseTest;
import com.automation.pages.AmazonHomePage;
import com.automation.pages.BasePage;
import com.google.common.util.concurrent.Uninterruptibles;

public class AccountUpdation extends BaseTest
{
	@Test
	public void updateAccInfo()
	{
	
	
		AmazonHomePage amazonHomePage = new AmazonHomePage();
		BasePage basePage = new BasePage();
		amazonHomePage.signin();
		amazonHomePage.Useremail();
		amazonHomePage.password();
		amazonHomePage.account();
		amazonHomePage.security();
		amazonHomePage.EditName();
		String name1="Indra Prasad";
		amazonHomePage.updateName(name1);
		
		String name = amazonHomePage.getname();
		System.out.println(name);
		Assert.assertEquals(name, name1);
		
		String resp=amazonHomePage.getResponse();
		System.out.println(resp);
		Assert.assertEquals(resp,"Name updated.");

	}
	
	
}
