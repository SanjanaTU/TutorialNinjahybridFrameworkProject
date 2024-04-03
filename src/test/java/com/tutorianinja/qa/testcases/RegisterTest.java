package com.tutorianinja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.BaseClass;
import com.tutorialninja.qa.pages.AccountSuccessPage;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.RegisterPage;
import com.tutorialninja.qa.utitiles.utilities;

public class RegisterTest extends BaseClass {

	public WebDriver driver;
	RegisterPage registerpage;
	AccountSuccessPage accountsuccesspage;
	
	public RegisterTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homepage = new HomePage(driver);
		registerpage=homepage.navigateToRegisterPage();
		

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void VerifyRegisterWithMandatoryFied() {
		
		accountsuccesspage	= registerpage.registerWithMandatoryFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),utilities.generateEmailWithTimeStamp(),dataProp.getProperty("Telephone"),prop.getProperty("validPassword"),prop.getProperty("validPassword"));
		Assert.assertEquals(accountsuccesspage.retriveaccountsuccesspageheading(), dataProp.getProperty("accounttsuccessfullycreatedmesaage"), "Account Success");

	}

	@Test(priority = 2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		accountsuccesspage=registerpage.registerWithAllFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),utilities.generateEmailWithTimeStamp(),dataProp.getProperty("Telephone"),prop.getProperty("validPassword"),prop.getProperty("validPassword"));
		Assert.assertEquals(accountsuccesspage.retriveaccountsuccesspageheading(), dataProp.getProperty("accounttsuccessfullycreatedmesaage"), "Account Success");


	}

	@Test(priority = 3)
	public void verifyResgisteringAccountWithExistingEmail() {
	
		registerpage.registerWithMandatoryFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),prop.getProperty("validEmail"),dataProp.getProperty("Telephone"),prop.getProperty("validPassword"),prop.getProperty("validPassword"));
		Assert.assertEquals(registerpage.retrieveDuplicateEmailAddressWarning(), dataProp.getProperty("duplicateemailmessage"), "Account Success");
	}
	

	@Test(priority = 4)
	public void verifyRegisterAccountWithoutAnyDetails() {
		
		registerpage.clickContinueButton();
		Assert.assertTrue(registerpage.displayStatusOfWarningMessage(dataProp.getProperty("privacypolicywarning"), dataProp.getProperty("FirstNameWarning"), dataProp.getProperty("LastNameWarning"), dataProp.getProperty("EmailWarning"), dataProp.getProperty("telephoneWarning"), dataProp.getProperty("PasswordWarning")));
		
	

	}
}
