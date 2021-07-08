package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.FrontPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.TestUtilDataProvider;
import com.crm.qa.pages.HomePage;

public class CreateNewContactPageTest extends TestBase{
	
	//1. Create instance variables and mainly Objects 
	//(i) Objects of PageClasses of current TestClass , 
	//(ii) Objects  of the LandingPage 
	CreateNewContactPage createNewContactPage;
	ContactPage contactPage;
	HomePage homePage;
	LoginPage loginPage;
	FrontPage frontPage;
	TestUtil testUtil;
	String sheetName="contacts";
	
	//2. Constructor to initialize super class constructor

	CreateNewContactPageTest(){
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
		frontPage.goToLogin();// Initial actions those should perform before test
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage=loginPage.login(objProperties.getProperty("username1"), objProperties.getProperty("password1"));// Initial login should perform before test
		contactPage=new ContactPage();
		contactPage=homePage.clickContact();//clicked on contact button
		createNewContactPage= new CreateNewContactPage();
		createNewContactPage=contactPage.createContactButtonClick();
		createNewContactPage.justCheck();
		System.out.println("In contact create page");
		testUtil = new TestUtil();
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

//	@Test
//	public void validatNewContactLevelTest() {
//		String title = contactPage.validatcontactLevel();
//		Assert.assertEquals(title, "Contacts","Level is not matched.");
//		System.out.println("Title Matched as Contact.");
//	}
	
/************************ This sould run from testng_parameter.xml file ***
	
	@Test
	@Parameters({"nameParameter"})
public void selectContactByNameWithParameterTest(String nameParameter) throws InterruptedException {
		driver.findElement(By.xpath("//thead[@class='full-width']//tr//th[3]")).click();
		contactPage.selectContactByNameWithParameter(nameParameter);
}
	
	************************ This sould run from testng_parameter.xml file ***/
	
//	@Test
//	public void createNewContactTest() throws InterruptedException  {
////		driver.findElement(By.xpath("//thead[@class='full-width']//tr//th[3]")).click();
////		contactPage.selectContactByName("Angsu Dutta");
//		//System.out.println("The check bos is selected "+contactPage.selectContactByName("Angsu Dutta"));
//		String s1="Lalit";
//		String s2="Paul";
//		createNewContactPage.createNewContact(s1, s2);
//		
//	}
	
/******************************************************************************* MyOwn	*****/
	
	@DataProvider								//single argument its take, as name, if no name then the method name is the DP name
	public Object[][] defaultDataProvider() {
		return new Object[][] {{"Name 1", "Last1"}, {"Name 2", "Last2"}};
	}
	
	@Test (dataProvider="defaultDataProvider")
	public void createNewContactBy_defaultDataProviderTest(String fnameFromDP,String lnameFromDP) throws InterruptedException { 
		//remember to create the arguments same number as data provider sheet contains , else column mismatch error will be there
		
		createNewContactPage.createNewContact(fnameFromDP, lnameFromDP);
	}
	
/*********************************************************************************/	
	
/********************************************************************* TestUtil.getTestData(sheetName)
	
	@DataProvider//single argument its take, as name, if no name then the method name is the DP name
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test (dataProvider="getCRMTestData")
	public void createNewContactByDataProviderTest(String fnameFromDP,String lnameFromDP) throws InterruptedException { 
		//remember to create the arguments same number as data provider sheet contains , else column mismatch error will be there
		
		createNewContactPage.createNewContact(fnameFromDP, lnameFromDP);
	}
	
	
*********************************************************************/
	
/*********************************************************************  TestUtilDataProvider*
	@Test(priority=3)
	public void createNewContactFromxlsxSheetTest() throws Exception {
		//remember to create the arguments same number as data provider sheet contains , else column mismatch error will be there
		
		String Path="C:\\Karabi\\WhiteBoxLearning\\Documents\\CodeWBL\\Automation\\src\\main\\java\\com\\crm\\qa\\data\\"; 
		String SheetName="contactList.xlsx";
		TestUtilDataProvider.setExcelFile(Path,SheetName);
		String fnameFromDP = TestUtilDataProvider.getCellData(1, 1);
		String lnameFromDP = TestUtilDataProvider.getCellData(1, 2);
		System.out.println("firstname = "+fnameFromDP+"lastname = "+lnameFromDP);
		//createNewContactPage.createNewContact(fnameFromDP, lnameFromDP);
	}
	
*********************************************************************/	
	
	@AfterMethod
	public void cleanBrowser() {
//		loginPage.logOut();
//		loginPage.checkLogout();
		driver.close();
	}

}
