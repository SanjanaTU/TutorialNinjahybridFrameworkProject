package com.tutorianinja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialninja.qa.base.BaseClass;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.SearchPage;

public class searchTest extends BaseClass {
	public WebDriver driver;
	SearchPage serachpage;
	HomePage homepage;

	public searchTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL("chrome");
		homepage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyingsearchwithexistingprduct() {
		serachpage=homepage.searchForAProduct(dataProp.getProperty("vaildProduct"));
		Assert.assertTrue(serachpage.displayStatusOfHPValidProduct(), "Valid product is not displayed");
	}

	@Test(priority = 2)
	public void verifyingsearchwithanonexistingProductname() {
		
		serachpage=homepage.searchForAProduct(dataProp.getProperty("invalidProduct"));
		Assert.assertEquals(serachpage.retrieveNoProductMessageText(), dataProp.getProperty("NoProductTextmessage"),
				"There is not message displayed");
	}

	@Test(priority = 3)
	public void verifysearchwithoutaproductnname() {
		serachpage = homepage.clickOnSearchButton();
		Assert.assertEquals(serachpage.retrieveNoProductMessageText(), dataProp.getProperty("NoProductTextmessage"),
				"There is not message displayed");
	}

}
