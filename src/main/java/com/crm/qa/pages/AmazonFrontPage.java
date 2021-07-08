package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;



public class AmazonFrontPage   extends TestBase{

	//1.  Define Object Repository
	Actions objAction= new Actions(driver);
	
	////a[@id='nav-logo-sprites']
	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement logo;

	//<span id="nav-link-accountList-nav-line-1" class="nav-line-1 nav-progressive-content">Hello, Sign in</span>
	@FindBy(id="nav-link-accountList-nav-line-1")
//	@FindBy(id="1nav-link-accountList-nav-line-1")
	WebElement goLoginButton;
	
	//<span class="nav-icon nav-arrow" style="visibility: visible;"></span>
	@FindBy(xpath="//span[@class='nav-icon nav-arrow']")
	WebElement arrowButton;
	
	//<span class="nav-action-inner">Sign in</span>
	@FindBy(xpath="//span[@class='nav-action-inner']")
	WebElement clickLoginButton;
	
	
	//2. Contructor
	public AmazonFrontPage() {
		PageFactory.initElements(driver, this); // all the element will be initialized to the driver
	}
	

	
	//3. All the features / methods
	public String validateTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateLogo() {		
		return logo.isDisplayed();
		
	}
	
	public AmazonLoginPage goToLogin() {
		if (goLoginButton.isDisplayed()) {
			objAction.moveToElement(goLoginButton).build().perform();
		}
		else {
			System.out.println("not displayed");
		}
		//arrowButton.click();
		clickLoginButton.click();
		return new AmazonLoginPage();
	}
	
	
}


