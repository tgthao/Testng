package com.nopcommerce.payment;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Level_02_AbstractPage_02_Extend extends AbstractPage{
	WebDriver driver;
	Select select;
	String email;

	@BeforeClass
	public void beforeClass() {
		// String rootFolder = System.getProperty("user.dir");
		String OS = System.getProperty("os.name").toLowerCase();

		if (OS.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "\\FileFoxlogs.txt");
		email = "giang_thao" + randomNumber() + "@hotmail.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register() {
		clickToElement(driver, "//a[@class='ico-register']");
		Assert.assertTrue(isElementDisplayed(driver, "//div[@class='page registration-page']"));
		clickToElement(driver, "//input[@id='gender-female']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "Thao");
		sendKeyToElement(driver, "//input[@id='LastName']", "Giang");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "10");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "October");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1990");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "MASCO123");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "MASCO123");
		clickToElement(driver, "//input[@id='register-button']");
		Assert.assertTrue(isElementDisplayed(driver, "//div[@class='result' and text()='Your registration completed']"));
		sleepInSecond(10);
		clickToElement(driver, "//a[contains(.,'Log out')]");
		Assert.assertEquals(getPageCurrentUrl(driver), "https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_02_Login() {
		clickToElement(driver, "//a[@class='ico-login']");
		sendKeyToElement(driver, "//input[@id='Email']", email);
		sendKeyToElement(driver, "//input[@id='Password']", "MASCO123");
		
	}

	@AfterClass
	public void afterClass() {
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(99999);
	}

}
