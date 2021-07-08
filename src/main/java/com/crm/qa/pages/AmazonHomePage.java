package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AmazonHomePage extends TestBase  {
	
	//1. Define Object repository
	
	//(i) Logo 
//	<a href="/ref=nav_logo" id="nav-logo-sprites" class="nav-logo-link nav-progressive-attribute" aria-label="Amazon">
//    <span class="nav-sprite nav-logo-base"></span>
//    <span id="logo-ext" class="nav-sprite nav-logo-ext nav-progressive-content"></span>
//    <span class="nav-logo-locale">.us</span>
//  </a>
	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement logo;
	
	//<span id="nav-link-accountList-nav-line-1" class="nav-line-1 nav-progressive-content">Hello, Testing</span>
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	@CacheLookup//it will chech the cache for better performance , but if the DOM model got changed , or browser refresh, then the cache will crash, steel element exception
	WebElement userVisibleName;
	
	//2. Constructor
	public AmazonHomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//3. Methods

	public boolean validateLogo() {		
		return logo.isDisplayed();
		
	}
	
	public String validateTitle() {
		String title = null;
		for(int x=1;x<10;x++) {
			
			System.out.println(driver.getTitle());
			title=driver.getTitle();
		}
		
		 
		 return title;
	}
	
	public boolean validateUserVisibleName() {
		if (userVisibleName.getText().equals("Hello, Testing")) {
			System.out.println("user is "+userVisibleName.getText());
			System.out.println("Title = "+ driver.getTitle());
			System.out.println("Title = "+ driver.getCurrentUrl());
			return true;
		}else return false;
		
	}
	
	
}
