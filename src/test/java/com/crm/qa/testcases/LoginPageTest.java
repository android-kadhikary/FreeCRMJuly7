package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FrontPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;

//import junit.framework.Assert;

public class LoginPageTest extends TestBase {

	FrontPage frontPage;
	LoginPage loginPage;
	HomePage homePage;
	
	LoginPageTest(){
		super(); // loading all the Object Repository from TestBase class (all the elements ei. objProperties, driver)
	}
	
	
	@BeforeMethod
	public void setup() {
		
		initialization(); //initialized the chromeDriver in driver object
		frontPage = new FrontPage();
		frontPage.goToLogin();
		loginPage=new LoginPage();//instance created so window max, url open
		
	}
	
	@Test(priority=1)
	public void loginPageTitelTest() {
		String title = loginPage.validateTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
//	@Test(priority=2)
//	public void crmLogoTest() {
//		boolean flag = loginPage.validateLogo();
//		Assert.assertTrue(flag);
//	}
	
	@Test(priority=3, groups= {"login"})
	public void loginTest() {
	homePage=	loginPage.login(objProperties.getProperty("username1"), objProperties.getProperty("password1"));
		
	}
	

	
	@AfterMethod
	public void cleanBrowser() {
//		loginPage.logOut();
//		loginPage.checkLogout();
		//Thread.sleep(2000);
		driver.close();
	}
	
	
}
