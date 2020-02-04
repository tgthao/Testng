package com.nopcomerce.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.LoginPO;
import nopComerce.pageObjects.PageGeneratorManager;


public class FE_02_Login extends AbstractTest {
	private WebDriver driver;
	private HomePO homePage;
	private LoginPO loginPage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = OpenMultiBrowsers(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	@Test
	public void TC_01_loginWithEmptyData() {
		log.info("Precondition - Step 01: Click to Login Link");
		loginPage = homePage.openLoginPage();
		log.info("Precondition - Step 02: Click to Login Link");
		homePage = loginPage.clickToLoginButton();
		log.info("Precondition - Step 03: Verify error message Please enter your email");
		verifyEquals(loginPage.getDynamicRequireFieldErrorMessage("Email"),"Please enter your email");
	}
	@Test
	public void TC_02_loginWithInvalidemail() {
		log.info("Precondition - TC - 02 loginWithInvalidemail Step 01: Click to Login Link");
		loginPage = homePage.openLoginPage();
		log.info("Precondition - TC - 02 Step 02: Input Wrong email");
		loginPage.inputtoDynamicTextbox("Email", "giang_thao57044");
		log.info("Precondition - TC - 03 Step 04: Click Login button");
		loginPage.clickToLoginButton();
		log.info("Precondition - TC - 02 Step 03: Verify error message Wrong Email");
		verifyEquals(loginPage.getDynamicRequireFieldErrorMessage("Email"),"Wrong email");
	}
	@Test
	public void TC_03_loginWithEmailNeverRegister() {
		log.info("Precondition - TC_03_loginWithEmailNeverRegister Step 01: Click to Login Link");
		loginPage = homePage.openLoginPage();
		log.info("Precondition - TC - 03 Step 02: Input email never registered");
		loginPage.inputtoDynamicTextbox("Email", "santafireball1406@gmail.com");
		log.info("Precondition - TC - 03 Step 03: Input password");
		loginPage.inputtoDynamicTextbox("Password", "santafireball1406@gmail.com");
		log.info("Precondition - TC - 03 Step 04: Click Login button");
		loginPage.clickToLoginButton();
		log.info("Precondition - TC - 03 Step 05: Verify error message Wrong Email Displayed");
		verifyTrue(loginPage.verifyWrongEmail("No customer account found"));
	}
	@Test
	public void TC_04_loginWithEmptyPassword() {
		log.info("Precondition - TC_04_loginWithEmailNeverRegister Step 01: Click to Login Link");
		loginPage = homePage.openLoginPage();
		log.info("Precondition - TC - 04 Step 02: Input valid email registered");
		loginPage.inputtoDynamicTextbox("Email", "giang_thao57044@hotmail.com");
		log.info("Precondition - TC - 04 Step 03: no input password");
		
		log.info("Precondition - TC - 04 Step 04: Click Login button");
		loginPage.clickToLoginButton();
		log.info("Precondition - TC - 04 Step 05: Verify error message Wrong Email Displayed");
		verifyTrue(loginPage.verifyWrongEmail("The credentials provided are incorrect"));
	}
	@Test
	public void TC_05_loginWithInvalidPassword() {
		log.info("Precondition - TC_04_loginWithEmailNeverRegister Step 01: Click to Login Link");
		loginPage = homePage.openLoginPage();
		log.info("Precondition - TC - 04 Step 02: Input valid email registered");
		loginPage.inputtoDynamicTextbox("Email", "giang_thao57044@hotmail.com");
		log.info("Precondition - TC - 04 Step 04: Input invalid password");
		loginPage.inputtoDynamicTextbox("Password", "santafireball1406@gmail.com");
		log.info("Precondition - TC - 03 Step 04: Click Login button");
		loginPage.clickToLoginButton();
		log.info("Precondition - TC - 03 Step 05: Verify error message Wrong Email Displayed");
		verifyTrue(loginPage.verifyWrongEmail("The credentials provided are incorrect"));
	}
	@Test
	public void TC_06_loginWithvalidData() {
		log.info("Home Page - Click to Login Link");
		loginPage = homePage.openLoginPage();
		log.info("Login Page - Verify Login Page is displayed");
		verifyTrue(loginPage.isLoginPageDisplayed());
		//verifyFalse(loginPage.isLoginPageDisplayed());
		log.info("Login Page - Input to Email textbox");
		
		loginPage.inputtoDynamicTextbox("Email", "giang_thao57044@hotmail.com");

		System.out.println("Login Page - Input to Password textbox");
		loginPage.inputtoDynamicTextbox("Password", "Masco123");

		System.out.println("Login Page - Click to Login Button -> Navigate to HomePage");
		homePage = loginPage.clickToLoginButton();

		System.out.println("Home Page -> Verify 'My Account' and 'Logout' Link Displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		verifyTrue(homePage.isLogoutLinkDisplayed());
		//verifyFalse(homePage.isLogoutLinkDisplayed());
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
		closeBrowserAndDriver(driver);
	}
}

