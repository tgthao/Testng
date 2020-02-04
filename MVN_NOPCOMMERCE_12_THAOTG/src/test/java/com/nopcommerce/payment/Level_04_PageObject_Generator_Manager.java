
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

import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.LoginPO;
import nopComerce.pageObjects.PageGeneratorManager;
import nopComerce.pageObjects.RegisterPO;

public class Level_04_PageObject_Generator_Manager {
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
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
		
	}
	@Test
	
	public void TC_01_Register() throws InterruptedException {
		homePage = PageGeneratorManager.getHomePage(driver);
		System.out.println(driver.toString());
		registerPage = homePage.openRegisterPage();
		System.out.println(driver.toString());
		
		registerPage.clickToMaleRadioButton();
		
		registerPage.inputToFirstNameTextbox("Thao");
		registerPage.inputToLastNameTextbox("Giang");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPassWordTextbox("Masco123");
		registerPage.inputToConfirmPassWordTextbox("Masco123");
		registerPage.clickToRegisterButton();
		
		registerPage.isDisplayedLogOutLink();
		homePage = registerPage.clicktoLogOutButton();
		//abc
		System.out.println(driver.toString());
	}
	@Test
	public void TC_02_Login() throws InterruptedException {
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(email);
		System.out.println(email);
		loginPage.inputPasswordTextbox("Masco123");
		loginPage.clickToLoginButton();
		
		//homePage.clickToLogoutButton();
	
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
