package com.tutorianinja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tutorialninja.qa.base.BaseClass;
import com.tutorialninja.qa.pages.AccountPage;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.LoginPage;
import com.tutorialninja.qa.utitiles.utilities;

public class LoginTest extends BaseClass {

	public LoginTest() {
		super();
	}

	public WebDriver driver;
	LoginPage loginpage;

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homepage = new HomePage(driver);
		loginpage = homepage.navigateToLoginPage();
	}

	@Test(priority = 1, dataProvider = "validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {
		AccountPage accountpage = loginpage.login(email, password);
		Assert.assertTrue(accountpage.checktheMessageIsDisplayed());
	}

	@DataProvider(name = "validCredentialsSupplier")
	public Object[][] supplyTestData() {
		Object[][] data = utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInValidCredentials() {
		loginpage.login(utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		String actualWarning = loginpage.getTheTextMesaage();
		String expectedWarning = dataProp.getProperty("emailPasswordWarningMessage");
		Assert.assertTrue(actualWarning.contains(expectedWarning),
				"Expected actauaWarning and expectedwarning are equal");
	}

	@Test(priority = 3)
	public void WithInvalidEMailAndValidPassword() {

		loginpage.login(utilities.generateEmailWithTimeStamp(), prop.getProperty("validPassword"));
		String actualWarning = loginpage.getTheTextMesaage();
		Assert.assertTrue(actualWarning.contains(dataProp.getProperty("emailPasswordWarningMessage")),
				"Expected actauaWarning and expectedwarning are equal");

	}

	@Test(priority = 4)
	public void WithValidEMailAndInvalidPassword() {
		loginpage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginpage.getTheTextMesaage().contains(dataProp.getProperty("emailPasswordWarningMessage")),
				"Expected actauaWarning and expectedwarning are equal");

	}

	@Test(priority = 5)
	public void WithoutPassingTheCredentials() {

		loginpage.clickLoginButton();
		String actualWarning = loginpage.getTheTextMesaage();
		Assert.assertTrue(actualWarning.contains(loginpage.getTheTextMesaage()),
				"Expected actauaWarning and expectedwarning are equal");
	}
}
