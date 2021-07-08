package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.FrontPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.HomePage;

public class ContactPageTest extends TestBase{
	
	//1. Create instance variables and mainly Objects 
	//(i) Objects of PageClasses of current TestClass , 
	//(ii) Objects  of the LandingPage 
	ContactPage contactPage;
	HomePage homePage;
	LoginPage loginPage;//instance created to call the methods
	FrontPage frontPage;
	
	//2. Constructor to initialize super class constructor

	ContactPageTest(){
		super();
	}
	
	//3. Start Testing steps before test, test and after test
		//initialization(); //initialized the chromeDriver in driver object,window max, url open,timeout set
		//amazonloginPage=new AmazonLoginPage();//instance created to call the methods
		//amazonloginPage = amazonFrontPage.goToLogin();// Initial actions those should perform before test
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		//amazonloginPage=new AmazonLoginPage();//instance created to call the methods
		frontPage = new FrontPage();
		frontPage.goToLogin();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage=loginPage.login(objProperties.getProperty("username1"), objProperties.getProperty("password1"));
		//homePage = new HomePage();
		

System.out.println(objProperties.getProperty("username1")+"    "+objProperties.getProperty("password1"));
		contactPage=new ContactPage();
		contactPage=homePage.clickContact();
	}
	
	
	
//	@Test(priority=2)
//	public void homePageURLTest() {
//		//amazonFrontPage.goToLogin();
//	System.out.println(driver.getCurrentUrl());	
//		//Assert.assertTrue(flag);
//	}
//	
//	
//	@Test(priority=3)
//	public void homePageTitelTest() {
//		String title = homePage.validateTitle();
//		Assert.assertEquals(title, "Cogmento CRM");
//		System.out.println("Title Matched Test 1");
//	}
//
//	@Test(priority=4)
//	public void homePageLogoTest() {
//		//amazonFrontPage.goToLogin();HomePageTest.java
//		boolean flag = homePage.validateLogo();
//		Assert.assertTrue(flag);
//	}
//	
	
//	@Test(priority=1)
//	public void validateUserVisibleNameTest() {
//
//		boolean flag = homePage.validateUserVisibleName();
//		Assert.assertTrue(flag);
//	}
	
//	@Test
//	public void validatcontactLevelTest() {
//		String title = contactPage.validatcontactLevel();
//		Assert.assertEquals(title, "Contacts","Level is not matched.");
//		System.out.println("Title Matched as Contact.");
//	}
	
	
	@Test
	@Parameters({"nameParameter"})
public void selectContactByNameWithParameterTest(String nameParameter) throws InterruptedException {
		driver.findElement(By.xpath("//thead[@class='full-width']//tr//th[3]")).click();
		contactPage.selectContactByNameWithParameter(nameParameter);
}
	
	
//	@Test
//	public void selectContactByNameWithoutParmTest() throws InterruptedException {
//		driver.findElement(By.xpath("//thead[@class='full-width']//tr//th[3]")).click();
//		contactPage.selectContactByName("Angsu Dutta");
//		//System.out.println("The check bos is selected "+contactPage.selectContactByName("Angsu Dutta"));
//		
//	}
	
	@AfterMethod
	public void cleanBrowser() {
//		loginPage.logOut();
//		loginPage.checkLogout();
		driver.close();
	}

}
