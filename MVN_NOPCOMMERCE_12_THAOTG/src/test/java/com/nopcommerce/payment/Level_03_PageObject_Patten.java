
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
import nopComerce.pageObjects.HomePageObject;
import nopComerce.pageObjects.LoginPageObject;
import nopComerce.pageObjects.RegisterPageObject;

public class Level_03_PageObject_Patten {
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
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
		
		
		email = "giang_thao" + randomNumber() + "@hotmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		System.out.println(driver.toString());
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void TC_01_Register() throws InterruptedException {
		homePage.openRegisterPage();
		registerPage = new RegisterPageObject(driver);
		registerPage.clickToRegisterButton();
		
		registerPage.clickToMaleRadioButton();
		
		registerPage.inputToFirstNameTextbox("Thao");
		registerPage.inputToLastNameTextbox("Giang");
		registerPage.inputToEmailTextbox(email);
		System.out.println(email);
		registerPage.inputToPassWordTextbox("Masco123");
		registerPage.inputToConfirmPassWordTextbox("Masco123");
		registerPage.clickToRegisterButton();
		
		registerPage.isDisplayedLogOutLink();
		Thread.sleep(3000);
		registerPage.clicktoLogOutButton();
		homePage = new HomePageObject(driver);
		//System.out.println(driver.toString());
	}
	@Test
	public void TC_02_Login() {
		
		homePage.openLoginPage();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(email);
		loginPage.inputPasswordTextbox("Masco123");
		loginPage.clickToLoginButton();
		
		//homePage.clickToLogoutButton();
		//homePage = new HomePageObject(driver);
		//Assert.assertTrue(homePage.isDisplayedLoginLink());	
		
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
