package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class FrontPage  extends TestBase {


	WebDriverWait w = new WebDriverWait(driver,5);//explicit WebDriverWait
	// Define Object Repository
	
	@FindBy(xpath="//span[@class='brand-slogan' ]")
	WebElement logo;

	//<span class="icon icon-xs mdi-chart-bar"></span>
	//error: org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <span class="icon icon-xs mdi-chart-bar"></span> is not clickable at point (1364, 65). Other element would receive the click: <div class="tibrr-cookie-consent-container" style="justify-content: space-between;">...</div>
	//@FindBy(xpath="//span[@class='icon icon-xs mdi-chart-bar']")
	
	@FindBy(xpath="//span[@class='icon icon-xs mdi-chart-bar']")
	WebElement goLoginButton;
	
	
	//<button style="border-color: rgb(0, 0, 0); font-size: 0.9em;">Got It</button>
	////div[@class='tibrr-cookie-consent-container']/div[2]/button
	@FindBy(xpath="//div[@class='tibrr-cookie-consent-container']//div[2]//button")
	WebElement gotItButton;
	
	public FrontPage() {
		PageFactory.initElements(driver, this); // all the element will be initialized to the driver
	}
	

	
	//<span class="icon icon-xs mdi-chart-bar"></span>
	// LOGO xpath= //span[@class='brand-slogan' ]
	///html/body/div[1]/header/div/nav/div/div/div[1]/div/a/svg/image

	public String validateTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateLogo() {		
		return logo.isDisplayed();
		
	}
	
//	if (gotIT.isDisplayed()) {
//		System.out.println("got it");
//		//System.out.println(" is  gOt it button clickable" +gotIT.is);
//		gotIT.click();
//	}
//	
//	if (submit.isDisplayed()) {
//		System.out.println("submit displayed");
//		submit.click();
//	}
	
	public LoginPage goToLogin() {
w.until(ExpectedConditions.visibilityOf(gotItButton));
		if (gotItButton.isDisplayed()) {
			System.out.println("got it");
			gotItButton.click();
		}
		
		if (goLoginButton.isDisplayed()) {
		//System.out.println("submit displayed");
		goLoginButton.click();
	}
		
		return new LoginPage();
	}
	
}
