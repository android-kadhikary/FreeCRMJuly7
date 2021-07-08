package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AmazonFrontPage;
import com.crm.qa.pages.AmazonLoginPage;
import com.crm.qa.pages.HomePage;

public class AmazonHomePageTest extends TestBase{
	
	//1. Create instance variables and mainly Objects 
	//(i) Objects of PageClasses of current TestClass , 
	//(ii) Objects  of the LandingPage 

	HomePage homePage;
	AmazonLoginPage amazonloginPage;//instance created to call the methods
	AmazonFrontPage amazonFrontPage;
	
	//2. Constructor to initialize super class constructor

	AmazonHomePageTest(){
		super();
	}
	
	//3. Start Testing steps before test, test and after test
		//initialization(); //initialized the chromeDriver in driver object,window max, url open,timeout set
		//amazonloginPage=new AmazonLoginPage();//instance created to call the methods
		//amazonloginPage = amazonFrontPage.goToLogin();// Initial actions those should perform before test
	
	@BeforeMethod
	public void setup() {
		initialization();
		//amazonloginPage=new AmazonLoginPage();//instance created to call the methods
		amazonFrontPage= new AmazonFrontPage();
		//homePage = new HomePage();
		amazonloginPage = amazonFrontPage.goToLogin();
		
		//amazonloginPage.login(objProperties.getProperty("username"), objProperties.getProperty("password"));
		
		homePage=	amazonloginPage.login(objProperties.getProperty("username"), objProperties.getProperty("password"));

System.out.println(objProperties.getProperty("username"));
	}
	
	
//	@Test(priority=2)
//	public void homePageURLTest() {
//		//amazonFrontPage.goToLogin();
//	System.out.println(driver.getCurrentUrl());	
//		//Assert.assertTrue(flag);
//	}
//	
	@Test(priority=3)
	public void homePageTitelTest() {
		String title = homePage.validateTitle();
		//Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.","Home page title is not matched");
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.","Home page title is not matched");
		 
		System.out.println("Title Matched Test 1");
	}
	
//	@Test(priority=4)
//	public void homePageLogoTest() {
//		//amazonFrontPage.goToLogin();HomePageTest.java
//		boolean flag = homePage.validateLogo();
//		Assert.assertTrue(flag);
//	}
	
	@Test(priority=1)
	public void validateUserVisibleNameTest() {
		
		boolean flag = homePage.validateUserVisibleName();
		Assert.assertTrue(flag);
	}
	
	
	
	@AfterMethod
	public void cleanBrowser() {
		driver.close();
	}

}
