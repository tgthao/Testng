
package com.nopcommerce.payment;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import pageFactory.HomePageFactory;
import pageFactory.LoginFactory;
import pageFactory.RegisterFactory;


public class Level_04_PageObject_Factory {
	private HomePageFactory homePage;
	private LoginFactory loginPage;
	private RegisterFactory registerPage;
	AbstractPage abstractPage;
	String email;
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		String OS = System.getProperty("os.name").toLowerCase();

		if (OS.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
			driver = new ChromeDriver();		 
			// driver = new SafariDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, ".\\FileFoxlogs.txt");
		}
		
		homePage = new HomePageFactory(driver);
		
		email = "giang_thao" + randomNumber() + "@hotmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		System.out.println(driver.toString());
	}
	
	@Test
	public void TC_01_Register() {
		homePage.clickRegisterURL();
		registerPage = new RegisterFactory(driver);
		registerPage.clickToRegisterButton();
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFirstNameTextbox("Thao");
		registerPage.inputToLastNameTextbox("Giang");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPassWordTextbox("Masco123");
		registerPage.inputToConfirmPassWordTextbox("Masco123");
		registerPage.clickToRegisterButton();
		Assert.assertTrue( registerPage.isDisplayedMessage());
		Assert.assertTrue( registerPage.isDisplayedLogOutLink());
		
		registerPage.clicktoLogOutButton();
		homePage = new HomePageFactory(driver);
		System.out.println(driver.toString());
	}
	@Test
	public void TC_02_Login() {
		
		
		homePage.clickToLoginLink();
		loginPage = new LoginFactory(driver);
		loginPage.inputToEmailTextbox(email);
		System.out.println(email);
		loginPage.inputPasswordTextbox("Masco123");
		loginPage.clickToLoginButton();
		
		homePage.clickToLogoutButton();
		homePage = new HomePageFactory(driver);
		Assert.assertTrue(homePage.isDisplayedLoginLink());	
		
	}
	public int randomNumber() {
		Random random = new Random();
		  return random.nextInt(99999);
	}
	@AfterClass
	public void quit() {
		driver.quit();
	}
}
