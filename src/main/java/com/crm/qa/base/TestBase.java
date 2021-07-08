package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

//import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	//1.  Static Global variable
	public static Properties objProperties; // import java.util.Properties; and public to access from other classes
	public static WebDriver driver;		//import org.openqa.selenium.WebDriver;
	
	
	/*WEb DRiver Fire Event*/
	public static EventFiringWebDriver e_driver; //import org.openqa.selenium.support.events.EventFiringWebDriver;
	public static WebEventListener eventListener;//import com.crm.qa.util.WebEventListener;
	
	//2.  Constructor should be public else will not be able to extend with the constructor 
	// error : Implicit super constructor TestBase() is not visible for default constructor. Must define an explicit constructor
		public TestBase(){
		try {
			objProperties = new Properties();
			FileInputStream input= new FileInputStream("C:\\Karabi\\WhiteBoxLearning\\Documents\\CodeWBL\\Automation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties"); //import java.io.FileInputStream;
			objProperties.load(input);
		}catch (FileNotFoundException e){	//import java.io.FileNotFoundException;
			
		}catch (IOException e){				//import java.io.IOException;
			
		}
		
	}
		
		
		//3. Initiallize the browser and all maxWindow, Timeout, cookies, get(url)
		public static void initialization() {
			String browserName= objProperties.getProperty("browser");
			if(browserName.equals("chrome")) {

				//Step 1: Webdriver.chrome.driver (is the property defined inside ChromeDriver class , that expect the path)
				System.setProperty("webdriver.chrome.driver","C:\\Karabi\\Chrome_driver\\chromedriver.exe");

				// Step 2 : create Driver Object for chrome browser
				driver = new ChromeDriver();
			}
			
//			else if(browserName.equals("firefox")) {
//
//				//Step 1: Webdriver.chrome.driver (is the property defined inside ChromeDriver class , that expect the path)
//				System.setProperty("webdriver.geco.driver","C:\\Karabi\\Chrome_driver\\gecodriver.exe");
//
//				// Step 2 : create Driver Object for chrome browser
//				driver = new ChromeDriver();
//			}
			
			
			/**** WebDRiver Fire Event Parameter Start ****/
			
//			e_driver= new EventFiringWebDriver(driver);//object created
//			eventListener= new WebEventListener();////object created
//			e_driver.register(eventListener);//register the listner with the EventFiringWebDriver	
//			driver=e_driver;//assign the event listerner driver to the driver			
			
			
//			e_driver= new EventFiringWebDriver(driver);//object created
//			eventListener= new WebEventListener();////object created
//			e_driver.register(eventListener);//register the listner with the EventFiringWebDriver	
//			driver=e_driver;//assign the event listerner driver to the driver
			
			/**** WebDRiver Fire Event Parameter ends *****/
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//System.out.println(" Instance created ");
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
//			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.NANOSECONDS);

// Refer from TestUtil class static variables			
//			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(objProperties.getProperty("url1"));
			//driver.get(objProperties.getProperty("url"));
			//System.out.println("url opened ");
			String currentDir = System.getProperty("user.dir");
			//System.out.println("current dir "+currentDir);
		}
		
		
}
