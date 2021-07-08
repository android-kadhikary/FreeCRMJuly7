package SeleniumFramework.Automation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.crm.qa.pages.AmazonFrontPage;
import com.crm.qa.pages.AmazonLoginPage;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}



//1. Create instance variables and mainly Objects 
	//(i) Objects of PageClasses of current TestClass , 
	//(ii) Objects  of the LandingPage 


//2. Constructor to initialize super class constructor


//3. Start Testing steps before test, test and after test
	//initialization(); //initialized the chromeDriver in driver object,window max, url open,timeout set
	//amazonloginPage=new AmazonLoginPage();//instance created to call the methods
	//amazonloginPage = amazonFrontPage.goToLogin();// Initial actions those should perform before test

