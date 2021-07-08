package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class IndivisualRecordsPage extends TestBase {

	
	//i[@class='large user red icon']
	
	@FindBy(xpath="//i[@class='large user red icon']")
	WebElement fullName;
}
