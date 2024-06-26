package com.tutorialninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialninja.qa.utitiles.utilities;

public class BaseClass {

	WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public BaseClass() {
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\tutorialninja\\qa\\config\\config.properties");
		
		
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\testData\\TestData.properties");
		try {
		FileInputStream dataFile = new FileInputStream(dataPropFile);
		dataProp.load(dataFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
				
		try {
			FileInputStream file = new FileInputStream(propFile);
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
