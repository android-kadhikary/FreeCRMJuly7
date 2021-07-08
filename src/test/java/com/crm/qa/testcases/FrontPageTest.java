package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FrontPage;
import com.crm.qa.pages.LoginPage;

public class FrontPageTest extends TestBase {
	FrontPage frontPage;
	LoginPage loginPage;
	
	FrontPageTest(){
		super(); // loading all the Object Repository from TestBase class (all the elements ei. objProperties, driver)
	}
	
	
	@BeforeMethod
	public void setup() {
		
		initialization(); //initialized the chromeDriver in driver object,window max, url open
		frontPage=new FrontPage();//instance created so 
		
	}
	
	@Test(priority=1)
	public void loginPageTitelTest() {
		String title = frontPage.validateTitle();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
		System.out.println("Title Matched Test 1");
	}
	
	@Test(priority=2)
	public void crmLogoTest() {
		boolean flag = frontPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void goTologinPageTest() {
		loginPage=	frontPage.goToLogin();
		
	}
	
	
	@AfterMethod
	public void cleanBrowser() {
		driver.close();
	}
	
}
