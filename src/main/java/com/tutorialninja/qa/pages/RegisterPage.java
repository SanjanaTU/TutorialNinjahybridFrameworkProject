package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	@FindBy(id = "input-firstname")
	WebElement FirstNameField;

	@FindBy(id = "input-lastname")
	WebElement LastNameField;

	@FindBy(id = "input-email")
	WebElement EmailField;

	@FindBy(id = "input-telephone")
	WebElement TelephoneField;

	@FindBy(id = "input-password")
	WebElement PasswordField;

	@FindBy(id = "input-confirm")
	WebElement ConfirmPasswordField;

	@FindBy(name = "agree")
	WebElement AgreePolicy;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement ContinueButton;
	
	@FindBy(xpath="//label[@class='radio-inline']//input")
	WebElement Subscribe;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAddressWarning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;


	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action

	public void enterFirstName(String FirstName) {
		FirstNameField.sendKeys(FirstName);
	}

	public void enterlastName(String Lastname) {
		LastNameField.sendKeys(Lastname);
	}

	public void enterEmailAddress(String Email) {
		EmailField.sendKeys(Email);
	}

	public void enterTelephoneNumber(String telephoneNumber) {
		TelephoneField.sendKeys(telephoneNumber);
	}
	
	public void enterPassword(String password) {
		PasswordField.sendKeys(password);
	}
	
	public void enterConfirmPassword(String ConfirmPassword) {
		PasswordField.sendKeys(ConfirmPassword);
	}
	
	public void ploicyCheck() {
		AgreePolicy.click();
			}
	
	public AccountSuccessPage clickContinueButton() {
		ContinueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void subscribeselectionforyesradiobutton() {
		Subscribe.click();
	}
	
    public String retrieveDuplicateEmailAddressWarning() {
    	String duplicateEmailWarningText = duplicateEmailAddressWarning.getText();
		return duplicateEmailWarningText;
	}
    
	public String retrievePasswordWarning() {
		
		String passwordWarningText = passwordWarning.getText();
		return passwordWarningText;
	}
	
	
	public String retrieveTelephoneWarning() {
		
		String telephoneWarningText = telephoneWarning.getText();
		return telephoneWarningText;
	}
	
	public String retrieveEmailWarning() {
		
		String emailWarningText = emailWarning.getText();
		return emailWarningText;
	}
	
	public String retrieveLastNameWarning() {
		
		String lastNameWarningText = lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	public String retrieveFirstNameWarning() {
		
		String firstNameWarningText = firstNameWarning.getText();
		return firstNameWarningText;
	}
	
	public String retrievePrivacyPolicyWarning() {
		
		String privacyPolicyWarningText = privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
		
	}
	
    public AccountSuccessPage registerWithMandatoryFields(String FirstName,String Lastname,String Email,String telephoneNumber,String password,String ConfirmPassword) {
    	FirstNameField.sendKeys(FirstName);
    	LastNameField.sendKeys(Lastname);
    	EmailField.sendKeys(Email);
    	TelephoneField.sendKeys(telephoneNumber);
    	PasswordField.sendKeys(password);
    	PasswordField.sendKeys(ConfirmPassword);
    	Subscribe.click();
    	AgreePolicy.click();
    	ContinueButton.click();
		return new AccountSuccessPage(driver);
    	
    }
    
    public AccountSuccessPage registerWithAllFields(String FirstName,String Lastname,String Email,String telephoneNumber,String password,String ConfirmPassword) {
    	FirstNameField.sendKeys(FirstName);
    	LastNameField.sendKeys(Lastname);
    	EmailField.sendKeys(Email);
    	TelephoneField.sendKeys(telephoneNumber);
    	PasswordField.sendKeys(password);
    	PasswordField.sendKeys(ConfirmPassword);
    	Subscribe.click();
    	AgreePolicy.click();
    	ContinueButton.click();
		return new AccountSuccessPage(driver);
    	
    }
    
    
    public boolean displayStatusOfWarningMessage(String expectedPrivacyPolicyWarning,String expectedfirstNameWarning,String expectedLastNameWarning,String expectedEmailAddressWarning,String expectedTelephoneWarning,String expectedpasswaordwarning) {

	
		boolean privacyPolicyWarningStatus = privacyPolicyWarning.getText().contains(expectedPrivacyPolicyWarning);
		boolean firstNameWarningStatus = firstNameWarning.getText().equals(expectedfirstNameWarning);
		boolean lastNameWarningStatus = lastNameWarning.getText().equals(expectedLastNameWarning);
		boolean emailWarningStatus = emailWarning.getText().equals(expectedEmailAddressWarning);
		boolean telephoneWarningStatus = telephoneWarning.getText().equals(expectedTelephoneWarning);
		boolean passwordWarningStatus = passwordWarning.getText().equals(expectedpasswaordwarning);
		return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
    }
    
}
