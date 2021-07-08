package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.*;

public class ContactPage extends TestBase{

	//1. Define Object repository
	
	WebDriverWait w = new WebDriverWait(driver,5);//explicit WebDriverWait
	
	// contactLevel
	////div[@class='ui loader']
	//@FindBy(xpath="//div[@class='ui loader']")
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactLevel;
	
	//Create Button
	////a[@href='/contacts/new']//button[@class='ui linkedin button']//i[@class='edit icon']
	
	@FindBy(xpath="//a[@href='/contacts/new']//button[@class='ui linkedin button']//i[@class='edit icon']")
	WebElement createContactButton;
	

	
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
	public ContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	//3. Methods

	public boolean validateLogo() {		
		return logo.isDisplayed();
		
	}
	
	public String validateTitle() {
		String title=driver.getTitle();
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
	
	public CreateNewContactPage createContactButtonClick() {
		w.until(ExpectedConditions.visibilityOf(createContactButton));
		createContactButton.click();
		return new CreateNewContactPage();
		
	}
	
	public String validatcontactLevel() {
		String contactLevelResult= contactLevel.getText();
		System.out.println("Contacts" +contactLevel.getText());
		return contactLevelResult;
	}
	
	
public boolean selectContactByNameWithParameter(String name) throws InterruptedException {
		
	System.out.println("parameter check "+name);
		if (driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div")).isDisplayed()){
			System.out.println("Displayed");
		}
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div"))));
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div")).click();
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div//input")).isSelected();

		
		
	}

	public boolean selectContactByName(String name) throws InterruptedException {
		
		if (driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div")).isDisplayed()){
			System.out.println("Displayed");
		}
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div"))));
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div")).click();
		Thread.sleep(20);
		if (driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div//input")).isSelected()){
			
			System.out.println("Selected Angsu");
		}
		
		//System.out.println("I am visible "+driver.findElement(By.xpath("//a[text()='Angsu Dutta']//parent::td//preceding-sibling::td//div//input")).getText());
		System.out.println("I am visible "+driver.findElement(By.xpath("//a[text()=\"Kumud Sen\"]")).getText());
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()=\"Kumud Sen\"]//parent::td//preceding-sibling::td//div"))));
		driver.findElement(By.xpath("//a[text()=\"Kumud Sen\"]//parent::td//preceding-sibling::td//div")).click();
		return driver.findElement(By.xpath("//a[text()=\"Kumud Sen\"]//parent::td//preceding-sibling::td//div")).isSelected();
		
		
	}
	
	


}
