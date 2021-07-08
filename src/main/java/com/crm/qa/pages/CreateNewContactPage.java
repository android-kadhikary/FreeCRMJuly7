package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class CreateNewContactPage extends TestBase {

	WebDriverWait w = new WebDriverWait(driver,5);//explicit WebDriverWait
	
	//Added entry 
	@FindBy(xpath="large user red icon")
	WebElement addedEntryName;
	
	//CreateNewContact save button
	@FindBy(xpath="//i[@class='save icon']")
	WebElement saveButton;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	public CreateNewContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void justCheck() {
		System.out.println("instance created for createcontact Page with out new key word");
	}
	
	public void createNewContact(String fname,String lname) throws InterruptedException {
		Thread.sleep(100);
		firstName.sendKeys(fname);
		Thread.sleep(100);
		lastName.sendKeys(lname);
		w.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
		Thread.sleep(100);
//		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='dashboard-toolbar']/div[@class='ui header item mb5 light-black']"))));
//		//if(driver.findElement(By.xpath("//div[@class='ui secondary pointing menu header-title page-header']/div[1]")).isDisplayed()) {
//		if(driver.findElement(By.xpath("//div[@id='dashboard-toolbar']/div[@class='ui header item mb5 light-black']")).isDisplayed()) {
//		
//			System.out.println("Name Added "+driver.findElement(By.xpath("//div[@id='dashboard-toolbar']/div[@class='ui header item mb5 light-black']")).getText());
//			
//		}
		
	}
	
	
}
