
package com.nopcommerce.payment;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPageObject;
import commons.AbstractTest;
import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.LoginPO;
import nopComerce.pageObjects.PageGeneratorManager;
import nopComerce.pageObjects.RegisterPO;


public class Level_12_Close_Browser_WebdriverManager extends AbstractTest {
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	private WebDriver driver;
	private AbstractPageObject abstractPage;
	String email, password;
	// private WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = OpenMultiBrowsers(browserName);
		abstractPage = new AbstractPageObject(driver);
		email = "giang_thao" + randomNumber() + "@hotmail.com";
		password ="AutomationTesting";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//sdriver.get("https://demo.nopcommerce.com");
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(false);
	}
	@Test
	public void TC_01_Register() {
		
	}
	@Test
	public void TC_02_Login() {
		System.out.println("Home Page - Click to Login Link");
		
	}

	@AfterClass(alwaysRun = true)
	public void quit() {
		closeBrowserAndDriver(driver);
	}
}
