
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AmazonFrontPage;
import com.crm.qa.pages.AmazonLoginPage;
import com.crm.qa.pages.FrontPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class AmazonLoginPageTest extends TestBase {

		AmazonFrontPage amazonFrontPage;
		AmazonLoginPage amazonloginPage;
		HomePage homePage;
		
		AmazonLoginPageTest(){
			super(); // loading all the Object Repository from TestBase class (all the elements ei. objProperties, driver)
		}
		
		
		@BeforeMethod
		public void setup() {
			
			initialization(); //initialized the chromeDriver in driver object,window max, url open,timeout set
			amazonloginPage=new AmazonLoginPage();//instance created to call the methods
			amazonFrontPage= new AmazonFrontPage();
			amazonloginPage = amazonFrontPage.goToLogin();// Initial actions those should perform before thest
		}
////		
//		@Test(priority=1)
//		public void callLoginPage() {
//			amazonFrontPage.goToLogin();
//		}
		
		@Test(priority=2)
		public void loginPageTitelTest() {
			String title = amazonFrontPage.validateTitle();
			Assert.assertEquals(title, "Amazon Sign-In","Login page title is not matched");
			System.out.println("Title Matched Test 1");
		}
		
	
		@Test(priority=3)
		public void amazonLogoTest() {
			//amazonFrontPage.goToLogin();
			boolean flag = amazonloginPage.validateLogo();
			Assert.assertTrue(flag);
		}
		
		@Test(priority=4)
		public void loginTest() {
		//amazonFrontPage.goToLogin();
		homePage=	amazonloginPage.login(objProperties.getProperty("username"), objProperties.getProperty("password"));
			
		}
		
		
		@AfterMethod
		public void cleanBrowser() {
			driver.close();
		}
		
		
	}
