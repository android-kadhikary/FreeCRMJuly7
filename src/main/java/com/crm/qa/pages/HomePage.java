package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase  {
	
	//1. Define Object repository
	
	//(i) Logo 
//	<a href="/ref=nav_logo" id="nav-logo-sprites" class="nav-logo-link nav-progressive-attribute" aria-label="Amazon">
//    <span class="nav-sprite nav-logo-base"></span>
//    <span id="logo-ext" class="nav-sprite nav-logo-ext nav-progressive-content"></span>
//    <span class="nav-logo-locale">.us</span>
//  </a>
	
	WebDriverWait w = new WebDriverWait(driver,5);//explicit WebDriverWait
	
	//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
	
	
	@FindBy(xpath="//div[@class='ui fluid container']//div[@class='ui navbar fixed main menu']//div")
	WebElement logo;
	
	@CacheLookup//it will chech the cache for better performance , but if the DOM model got changed , or browser refresh, then the cache will crash, steel element exception
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userVisibleName;
	
	
	// Main Panel
	//<div id="main-nav" class="ui left fixed vertical  icon menu sidebar-dark left-to-right"><div class="menu-item-wrapper"><a class="item" href="/home"><i class="home icon"></i><span class="item-text">Home</span></a></div><div class="menu-item-wrapper"><a class="item" href="/calendar"><i class="calendar icon"></i><span class="item-text">Calendar</span></a><button class="ui mini basic icon button"><i aria-hidden="true" class="plus inverted icon"></i></button></div><div class="menu-item-wrapper"><a class="item" href="/contacts"><i class="users icon"></i><span class="item-text">Contacts</span></a><button class="ui mini basic icon button"><i aria-hidden="true" class="plus inverted icon"></i></button></div><div class="menu-item-wrapper"><a class="item" href="/companies"><i class="building icon"></i><span class="item-text">Companies</span></a><button class="ui mini basic icon button"><i aria-hidden="true" class="plus inverted icon"></i></button></div><div class="menu-item-wrapper"><a class="item" href="/deals"><i class="money icon"></i><span class="item-text">Deals</span></a><button class="ui mini basic icon button"><i aria-hidden="true" class="plus inverted icon"></i></button></div><div class="menu-item-wrapper"><a class="item" href="/tasks"><i class="tasks icon"></i><span class="item-text">Tasks</span></a><button class="ui mini basic icon button"><i aria-hidden="true" class="plus inverted icon"></i></button></div><div class="menu-item-wrapper"><a class="item" href="/cases"><i class="comments icon"></i><span class="item-text">Cases</span></a><button class="ui mini basic icon button"><i aria-hidden="true" class="plus inverted icon"></i></button></div><div class="menu-item-wrapper"><a class="item" href="/calls"><i class="phone icon"></i><span class="item-text">Calls</span></a><button class="ui mini basic icon button"><i aria-hidden="true" class="plus inverted icon"></i></button></div><div class="menu-item-wrapper"><a class="item" href="/documents"><i class="file icon"></i><span class="item-text">Documents</span></a><button class="ui mini basic icon button"><i aria-hidden="true" class="plus inverted icon"></i></button></div><div class="menu-item-wrapper"><a class="item" href="/email"><i class="mail outline icon"></i><span class="item-text">Email</span></a></div><div class="menu-item-wrapper"><a class="item" href="/campaigns"><i class="target icon"></i><span class="item-text">Campaigns</span></a></div><div class="menu-item-wrapper"><a class="item" href="/forms"><i class="wpforms icon"></i><span class="item-text">Forms</span></a></div></div>
	@FindBy(xpath="//div[@id='main-nav']")	
	WebElement mainPanel;

	@FindBy(xpath="//i[@class='users icon']")
	WebElement contacts;
	
	Actions actionObj;

	//2. Constructor
	public HomePage(){
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
		w.until(ExpectedConditions.visibilityOf(userVisibleName));
		if (userVisibleName.getText().equals("k A")) {
			System.out.println("user is "+userVisibleName.getText());
//			System.out.println("Title = "+ driver.getTitle());
//			System.out.println("Title = "+ driver.getCurrentUrl());
			return true;
		}else return false;
		
	}
	
	public ContactPage clickContact() throws InterruptedException {
		w.until(ExpectedConditions.visibilityOf(mainPanel));
		if(mainPanel.isDisplayed()) {
			System.out.println("displayed main pannel");
		}
		//actionObj.moveToElement(mainPanel).build().perform();
		Thread.sleep(100);
		contacts.click();
		return new ContactPage();
	}
	
	public ContactPage clickCalender() {
//		actionObj.moveToElement(mainPanel).build().perform();
//		contacts.click();
		return new ContactPage();
	}
	
	public ContactPage clickDeals() {
//		actionObj.moveToElement(mainPanel).build().perform();
//		contacts.click();
		return new ContactPage();
	}
	
	
}
