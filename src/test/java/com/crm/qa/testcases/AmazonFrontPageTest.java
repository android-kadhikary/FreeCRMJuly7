package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AmazonFrontPage;
import com.crm.qa.pages.AmazonLoginPage;

public class AmazonFrontPageTest extends TestBase {
	
	//1. Create instance variables and mainly Objects 
	//(i) Objects of PageClasses of current TestClass , 
	//(ii) Objects  of the LandingPage 
	
	
	AmazonFrontPage amazonFrontPage;
	AmazonLoginPage amazonLoginPage;
	
	
	//2. Constructor to initialize super class constructor
	
	AmazonFrontPageTest(){
		super(); // loading all the Object Repository from TestBase class (all the elements ei. objProperties, driver)
	}
	
	
	
	//3. Start Testing steps before test, test and after test
	
	@BeforeMethod
	public void setup() {
		
		initialization(); //initialized the chromeDriver in driver object,window max, url open
		amazonFrontPage=new AmazonFrontPage();//instance created so 
		
	}
	
	@Test(priority=1)
	public void loginPageTitelTest() {
		String title = amazonFrontPage.validateTitle();
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.","Title is not match");
		System.out.println("Title Matched Test 1");
	}
	
	@Test(priority=2)
	public void amazonLogoTest() {
		boolean flag = amazonFrontPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void goTologinPageTest() {
		amazonLoginPage=	amazonFrontPage.goToLogin();
		
	}
	
	
	@AfterMethod
	public void cleanBrowser() {
		driver.close();
	}
	
}