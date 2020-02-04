
package com.nopcommerce.payment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPageObject;
import commons.AbstractTest;
import driverfactoryPattern.DriverManager;
import driverfactoryPattern.DriverManagerFactory;
import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.LoginPO;
import nopComerce.pageObjects.PageGeneratorManager;

public class Level_10_Check_Element_Undisplayed extends AbstractTest{
	private DriverManager driverManager;
	private HomePO homePage;
	private LoginPO loginPage;

	private WebDriver driver;
	private AbstractPageObject abstractPage;
	String email;

	// private WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver();
		abstractPage = new AbstractPageObject(driver);
		email = "giang_thao" + randomNumber() + "@hotmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
	}

	@Test
	public void TC_02_Login() throws InterruptedException {
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.openLoginPage();
		Thread.sleep(3000);

		System.out.println("Login Page - Input to Email textbox");
		loginPage.inputToEmailTextbox("giang_thao57044@hotmail.com");

		System.out.println("Login Page - Input to Password textbox");
		loginPage.inputPasswordTextbox("Masco123");

		System.out.println("Login Page - Click to Login Button -> Navigate to HomePage");
		homePage = loginPage.clickToLoginButton();

		System.out.println("Home Page -> Verify 'My Account' and 'Logout' Link Displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());

		abstractPage = new AbstractPageObject(driver);
		abstractPage.sleepInSecond(2);
		homePage.clickToLogoutButton(); //

		/*
		 * System.out.println("Verify Login and Register Undisplayed");
		 * Assert.assertFalse(homePage.isRegisterLinkUndisplayed());
		 */
		System.out.println("Verify Login displayed");
		Assert.assertTrue(homePage.isLogInLinkdisplayed());
	}

	@AfterClass
	public void quit() {
		driver.quit();
	}
}
