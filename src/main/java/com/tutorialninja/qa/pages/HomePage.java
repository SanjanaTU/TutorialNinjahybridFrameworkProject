package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public void clickOnmyAccountDropMenu() {
		myAccountDropMenu.click();
	}
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public LoginPage navigateToLoginPage() {
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	public RegisterPage RegisterOptionClick() {
		RegisterOption.click();
		 return new RegisterPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		myAccountDropMenu.click();
		RegisterOption.click();
		 return new RegisterPage(driver);
	}
	
       public SearchPage clickOnSearchButton() {
		
		searchButton.click();
		return new SearchPage(driver);
		
	}
       
    
	
	public SearchPage searchForAProduct(String productText) {
		
		searchBoxField.sendKeys(productText);
		searchButton.click();
		return new SearchPage(driver);
		
	}
	
	public void enterProductIntoSearchBoxField(String productText) {
		
		searchBoxField.sendKeys(productText);
		
	}
	

}
