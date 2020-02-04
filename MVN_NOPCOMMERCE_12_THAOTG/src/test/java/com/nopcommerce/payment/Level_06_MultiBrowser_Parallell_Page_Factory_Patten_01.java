
package com.nopcommerce.payment;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.LoginPO;
import nopComerce.pageObjects.PageGeneratorManager;
import nopComerce.pageObjects.RegisterPO;

public class Level_06_MultiBrowser_Parallell_Page_Factory_Patten_01 extends AbstractTest{
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	AbstractPage abstractPage;
	String email;
	private WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = OpenMultiBrowsers(browserName);
		email = "giang_thao" + randomNumber() + "@hotmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		System.out.println("Driver at Testcase"+driver.toString());
/**		switch (browserName) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, ".\\FileFoxlogs.txt");
			driver = new FirefoxDriver();
			break;
		case "firefox_headless":
			System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "chrome_headless":
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			ChromeOptions optionChrome = new ChromeOptions();
			optionChrome.setHeadless(true);
			driver = new ChromeDriver(optionChrome);
			break;
		default:
			System.out.println("Please input name browser");
			break;
		} **/
			
//		String OS = System.getProperty("os.name").toLowerCase();
//
//		if (OS.contains("mac")) {
//			System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
//			driver = new ChromeDriver();		 
//			// driver = new SafariDriver();
//		} else {
//			System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");
//			driver = new FirefoxDriver();
//			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, ".\\FileFoxlogs.txt");
//		}
//		
//		
//		email = "giang_thao" + randomNumber() + "@hotmail.com";
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://demo.nopcommerce.com");
		//System.out.println(driver.toString());
		
	}


	public void TC() {

	}

	@Test
	public void TC_01_Register() throws InterruptedException {

		homePage = PageGeneratorManager.getHomePage(driver);
		abstractPage = new AbstractPage();
		
		registerPage = homePage.openRegisterPage();
		abstractPage.sleepInSecond(4);
		registerPage.clickToMaleRadioButton();

		registerPage.inputToFirstNameTextbox("Thao");
		registerPage.inputToLastNameTextbox("Giang");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPassWordTextbox("Masco123");
		registerPage.inputToConfirmPassWordTextbox("Masco123");
		registerPage.clickToRegisterButton();
		abstractPage.sleepInSecond(3);
		registerPage.isDisplayedLogOutLink();
		homePage = registerPage.clicktoLogOutButton(); // abc
		System.out.println(driver.toString());
		abstractPage.sleepInSecond(3);
	}

	@Test

	public void TC_02_Login() throws InterruptedException {

		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(email);
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
