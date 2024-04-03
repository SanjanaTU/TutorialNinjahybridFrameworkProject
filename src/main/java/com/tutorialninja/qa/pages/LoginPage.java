package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement clickLoginButton;
	
	@FindBy(xpath="//div[text()='Warning: No match for E-Mail Address and/or Password.']")
	WebElement actualWarningMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public void sendEmailAddress(String EmailText) {
		emailAddressField.sendKeys(EmailText);
	}

	public void sendPasswordAddress(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public AccountPage clickLoginButton() {
		clickLoginButton.click();
		return new AccountPage(driver);
	}
	
	
	public AccountPage login(String EmailText,String passwordText) {
		emailAddressField.sendKeys(EmailText);
		passwordField.sendKeys(passwordText);
		clickLoginButton.click();
		return new AccountPage(driver);
		
	}
	
	public String getTheTextMesaage() {
		String warningText=actualWarningMessage.getText();
		return warningText;
	}
}
