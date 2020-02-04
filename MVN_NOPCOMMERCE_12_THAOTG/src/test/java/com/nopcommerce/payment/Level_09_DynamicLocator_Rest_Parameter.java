
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
import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.LoginPO;
import nopComerce.pageObjects.PageGeneratorManager;
import nopComerce.pageObjects.RegisterPO;
import nopComerce.pageObjects.SearchPO;
import nopComerce.pageObjects.ShippingAndReturnPO;
import nopComerce.pageObjects.SitemapPO;

public class Level_09_DynamicLocator_Rest_Parameter {
	private DriverManager driverManager;
	private HomePO homePage;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	private SitemapPO siteMapPO;
	private ShippingAndReturnPO shippingAndReturnPO;
	private FooterMyAccountPO footerMyAccountPO;
	private SearchPO searchPO;
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
		email = "giang_thao" + abstractPage.randomNumber() + "@hotmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
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
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.openLoginPage();
		Thread.sleep(3000);
		loginPage.inputToEmailTextbox("giang_thao82439@hotmail.com");
		loginPage.inputPasswordTextbox("Masco123");
		homePage = loginPage.clickToLoginButton();
		abstractPage = new AbstractPageObject(driver);
		abstractPage.sleepInSecond(2);
		// homePage.clickToLogoutButton();
		// Assert.assertTrue(homePage.isDisplayedLoginLink());
		
		footerMyAccountPO = PageGeneratorManager.getFooterMyAccountPage(driver);
	}

	@Test
	public void TC_03_Dynamic_Locator_MultiPages() throws InterruptedException {
		// Footer My Account -> Site map
		footerMyAccountPO.openMultiPageNopCommercePages("Sitemap");
		siteMapPO = PageGeneratorManager.getSitemapPage(driver);
		Thread.sleep(3000);
		// Site map -> Shipping & returns
		siteMapPO.openMultiPageNopCommercePages("Shipping & returns");
		shippingAndReturnPO = PageGeneratorManager.getShippingAndReturnPage(driver);
		// Shipping & returns -> Footer My Account
		shippingAndReturnPO.openMultiPageNopCommercePages("My account");
		footerMyAccountPO = PageGeneratorManager.getFooterMyAccountPage(driver);
		// Footer My Account -> Search
		footerMyAccountPO.openMultiPageNopCommercePages("Search");
		searchPO = PageGeneratorManager.getSearchPage(driver);
		// Search -> Shipping & returns
		searchPO.openMultiPageNopCommercePages("Shipping & returns");
		shippingAndReturnPO = PageGeneratorManager.getShippingAndReturnPage(driver);
		// Shipping & Return -> Footer My Account
		shippingAndReturnPO.openMultiPageNopCommercePages("My account");
		footerMyAccountPO = PageGeneratorManager.getFooterMyAccountPage(driver);
	}

	@AfterClass
	public void quit() {
		driver.quit();
	}
}
