package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement accountsuccesspageheading;
		

	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Action
	
	public String retriveaccountsuccesspageheading() {
		String accountSuccessPageHeadingText=accountsuccesspageheading.getText();
		return accountSuccessPageHeadingText;
	}
}
