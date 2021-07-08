package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase  {


	public boolean loginStatus=false;
	WebDriverWait w = new WebDriverWait(driver,5);//explicit WebDriverWait
	
	//1. Define Object repository
	//<input type="text" name="email" placeholder="E-mail address" value="" class="">
	@FindBy(name="email")
	WebElement email;
	
	//<input type="password" name="password" placeholder="Password" value="" class="">
	@FindBy(name="password")
	WebElement password;
	
	//<div class="ui fluid large blue submit button">Login</div>
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;
	
	//<a href="https://register.cogmento.com/password/reset/request/">Forgot your password?</a>
	@FindBy(xpath="//a[contains(text(),'Forgot your password')]")
	WebElement forgotPasswordButton;
	
	@FindBy(xpath="//*[@id=\"top-header-menu\"]/div[1]")
	WebElement logo;
	
	//@FindBy(xpath="//div[@class='ui basic button floating item dropdown']")
	@FindBy(xpath="//i[@class='settings icon']")
	WebElement settingButton;
	
	@FindBy(xpath="//span[text()=\"Log Out\"]")
	WebElement logoutButton;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement checkLogout;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this); // all the element will be initialized to the driver
	}
	
	public String validateTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateLogo() {		
		return logo.isDisplayed();
		
	}
	
	public HomePage login(String emailID,String passwordID) {
		email.sendKeys(emailID);
		password.sendKeys(passwordID);
		loginButton.click();
		this.loginStatus=true;
		return new HomePage();
	}
	
	public void checkLogout() {
		if(checkLogout.isDisplayed()) {
			System.out.println("Logout Successfull");
		}
		
	}
	public void logOut() {
		if(loginStatus==true) {
			settingButton.click();
			w.until(ExpectedConditions.visibilityOf(logoutButton));
			if(logoutButton.isDisplayed()) {
				logoutButton.click();	
		}

	}
	
	}
	
	
	
	
	
	
	
	
}
