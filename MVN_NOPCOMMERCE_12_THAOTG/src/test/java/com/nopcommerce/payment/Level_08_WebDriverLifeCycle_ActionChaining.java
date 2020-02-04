
package com.nopcommerce.payment;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPageObject;
import driverfactoryPattern.DriverManager;
import driverfactoryPattern.DriverManagerFactory;
import nopComerce.pageObjects.FooterMyAccountPO;
import nopComerce.pageObjects.HeaderMyAccountPO;
import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.LoginPO;
import nopComerce.pageObjects.PageGeneratorManager;
import nopComerce.pageObjects.RegisterPO;
import nopComerce.pageObjects.SearchPO;
import nopComerce.pageObjects.ShippingAndReturnPO;
import nopComerce.pageObjects.SitemapPO;

public class Level_08_WebDriverLifeCycle_ActionChaining{
	private DriverManager driverManager;
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	private HeaderMyAccountPO headerMyAcountPO;
	private SitemapPO siteMapPO;
	private ShippingAndReturnPO shippingAndReturnPO;
	private FooterMyAccountPO footerMyAccountPO;
	private SearchPO searchPO;
	private WebDriver driver;
	private AbstractPageObject abstractPage;
	String email;
	//private WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverManager =  DriverManagerFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver();
		abstractPage = new AbstractPageObject(driver);
		email = "giang_thao" + abstractPage.randomNumber() + "@hotmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		
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
		
		homePage = PageGeneratorManager.getHomePage(driver);
		abstractPage = new AbstractPageObject(driver);
	}
	

	public void TC() {

	}

	
	public void TC_01_Register() {

		
		
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
		Thread.sleep(3000);
		loginPage.inputToEmailTextbox("giang_thao82439@hotmail.com");
		loginPage.inputPasswordTextbox("Masco123");
		homePage = loginPage.clickToLoginButton();
		abstractPage = new AbstractPageObject(driver);
		abstractPage.sleepInSecond(2);

		//homePage.clickToLogoutButton();

		//Assert.assertTrue(homePage.isDisplayedLoginLink());

	}
	@Test
	public void TC_03_ActionChaining() {
		//Home Page-> Header My account
		headerMyAcountPO = homePage.openHeaderMyAccountPage();
		//Header My Account -> Home Page
		homePage = headerMyAcountPO.openHomePage();
		//Header My Account -> Footer (Site map)
		siteMapPO = headerMyAcountPO.openSiteMapPage();
		//Sitemap -> Shipping & returns 
		shippingAndReturnPO = siteMapPO.openShippingAndReturnPage();
		//Shipping & returns -> Footer My Account
		footerMyAccountPO = shippingAndReturnPO.openFooterMyAccountPage();
		//Footer My Account -> Search
		searchPO = footerMyAccountPO.openSearchPage();
		shippingAndReturnPO = searchPO.openShippingAndReturnPage();
		
		
	}

	@AfterClass
	public void quit() {
		driver.quit();
	}
}
