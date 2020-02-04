package com.nopcommerce.payment;

import org.testng.annotations.Test;

import commons.AbstractPage;


import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Level_02_AbstractPage {
	WebDriver driver;
	AbstractPage abstractPage;
	Select select;
	String email;

	@BeforeClass
	public void beforeClass() {
		// String rootFolder = System.getProperty("user.dir");
		String OS = System.getProperty("os.name").toLowerCase();
		String path = System.getProperty("user.dir");
		if (OS.contains("mac")) {
			System.setProperty("webdriver.gecko.driver", path+ "/resources/geckodriver");
			
	        driver = new FirefoxDriver();
	        driver.get("https://demo.nopcommerce.com/");

			
		} else {
			System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, ".\\FileFoxlogs.txt");
		}
		
		abstractPage = new AbstractPage();
		email = "giang_thao" + randomNumber() + "@hotmail.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register() {
		abstractPage.clickToElement(driver, "//a[@class='ico-register']");
		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//div[@class='page registration-page']"));
		abstractPage.clickToElement(driver, "//input[@id='gender-female']");
		abstractPage.sendKeyToElement(driver, "//input[@id='FirstName']", "Thao");
		abstractPage.sendKeyToElement(driver, "//input[@id='LastName']", "Giang");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "10");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "October");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1990");
		abstractPage.sendKeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendKeyToElement(driver, "//input[@id='Password']", "MASCO123");
		abstractPage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "MASCO123");
		abstractPage.clickToElement(driver, "//input[@id='register-button']");
		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//div[@class='result' and text()='Your registration completed']"));
		abstractPage.sleepInSecond(10);
		abstractPage.clickToElement(driver, "//a[contains(.,'Log out')]");
		Assert.assertEquals(abstractPage.getPageCurrentUrl(driver), "https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_02_Login() {
		abstractPage.clickToElement(driver, "//a[@class='ico-login']");
		abstractPage.sendKeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendKeyToElement(driver, "//input[@id='Password']", "MASCO123");
		abstractPage.clickToElement(driver, "//input[@class='button-1 login-button' and @value='Log in']");
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(99999);
	}

}
