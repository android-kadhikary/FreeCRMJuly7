package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AmazonLoginPage extends TestBase  {

	
	//1. Define Object repository
	
	////a[@id='nav-logo-sprites']
	//<i class="a-icon a-icon-logo" role="img" aria-label="Amazon"></i>
	@FindBy(xpath="//i[@class='a-icon a-icon-logo']")
	WebElement logo;
	
	
	//<input type="text" name="email" placeholder="E-mail address" value="" class="">
	@FindBy(name="email")
	WebElement email;

	//<input id="continue" tabindex="5" class="a-button-input" type="submit" aria-labelledby="continue-announce">	
	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement continueButton;
	
	//<input type="password" name="password" placeholder="Password" value="" class="">
	//<input type="password" maxlength="1024" id="ap_password" name="password" tabindex="2" class="a-input-text a-span12 auth-autofocus auth-required-field">
	@FindBy(name="password")
	WebElement password;
	

//<input id="signInSubmit" tabindex="5" class="a-button-input" type="submit" aria-labelledby="auth-signin-button-announce">
	@FindBy(id="signInSubmit")
	WebElement loginButton;
	
	
	
	public AmazonLoginPage() {
		PageFactory.initElements(driver, this); // all the element will be initialized to the driver
	}

	
	public String validateTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateLogo() {		
		return logo.isDisplayed();
		
	}
	
	public void clickContinue() {		
		continueButton.click();;
		
	}
	
	public HomePage login(String emailID,String passwordID) {
		email.sendKeys(emailID);
		if (continueButton.isDisplayed()) {
			clickContinue();
		}else {
			
			System.out.println("send Password");
		}
		password.sendKeys(passwordID);
	
		loginButton.click();
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
}
