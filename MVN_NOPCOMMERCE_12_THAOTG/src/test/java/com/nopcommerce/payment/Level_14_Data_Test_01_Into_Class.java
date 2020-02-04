
package com.nopcommerce.payment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPageObject;
import commons.AbstractTest;
import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.LoginPO;
import nopComerce.pageObjects.PageGeneratorManager;
import nopComerce.pageObjects.RegisterPO;

public class Level_14_Data_Test_01_Into_Class extends AbstractTest {
	private HomePO homePage;
	private RegisterPO registerPage;
	private LoginPO loginPage;
	private WebDriver driver;
	private AbstractPageObject abstractPage;
	// Declare variable
	public static String EMAIL, PASSWORD;
	String confirmpasswordError;
	String firstName, lastName, companyName;

	// private WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = OpenMultiBrowsers(browserName);
		abstractPage = new AbstractPageObject(driver);

		homePage = PageGeneratorManager.getHomePage(driver);
		// Init variable
		EMAIL = "giang_thao" + randomNumber() + "@hotmail.com";
		PASSWORD = "AutomationTesting";
		firstName = "Adeline";
		lastName = "Arnaud";
		companyName = "Lectra SAS";

		confirmpasswordError = "Password is required.";
	}

	@Parameters("{firstnameError;lastnameError;emailError;passwordError}")
	@Test
	public void TC_01_Validate_Register_Form(String firstnameError,String lastnameError,String emailError,String  passwordError ) {
		log.info("Validate- Step 01: - Click to Register Link");
		registerPage = homePage.openRegisterPage();
		log.info("Validate- Step 02: - Click to Register Button");
		registerPage.clickToDynamicButton("Register");
		log.info("Validate- Step 03: - Verify Error Message Displayed");
		verifyEquals(registerPage.getDynamicRequireFieldErrorMessage("FirstName"), firstnameError);
		verifyEquals(registerPage.getDynamicRequireFieldErrorMessage("LastName"), lastnameError);
		verifyEquals(registerPage.getDynamicRequireFieldErrorMessage("Email"), emailError);
		verifyEquals(registerPage.getDynamicRequireFieldErrorMessage("Password"), passwordError);
		verifyEquals(registerPage.getDynamicRequireFieldErrorMessage("ConfirmPassword"), passwordError);

	}

	@Test
	public void TC_02_Register() {

		log.info("TC_01_Register-Homepage - Click to Register Link");
		log.info("Precondition - Step 01: Click to Register Link");
		registerPage = homePage.openRegisterPage();

		log.info("Precondition - Step 02: Verify Register is displayed");
		verifyTrue(registerPage.isRegisterPageDisplayed());

		log.info("Precondition - Step 03: Input all data required fields");
		abstractPage.sleepInSecond(1);
		log.info("Register Page - Click to Gender radio button");
		registerPage.clickToDynamicRadioButton("gender-male");
		log.info("Register Page - Input to Firstname textbox");
		registerPage.inputtoDynamicTextbox("FirstName", firstName);
		log.info("Register Page - Input to Lastname textbox");
		registerPage.inputtoDynamicTextbox("LastName", lastName);
		registerPage.inputtoDynamicTextbox("Company", companyName);
		registerPage.inputtoDynamicTextbox("Email", EMAIL);
		registerPage.inputtoDynamicTextbox("Password", PASSWORD);
		registerPage.inputtoDynamicTextbox("ConfirmPassword", PASSWORD);
		registerPage.clickToDynamicButton("Register");

		log.info("Precondition - Step 04: Verify success message correct");
		assertEquals(registerPage.getSuccessMessageText(), "Your registration completed");
		abstractPage.sleepInSecond(3);
		registerPage.isDisplayedLogOutLink();
		System.out.println(driver.toString());
		abstractPage.sleepInSecond(3);
		homePage = registerPage.clicktoLogOutButton();
	}

	@Test
	public void TC_03_Login() {
		log.info("Home Page - Click to Login Link");
		loginPage = homePage.openLoginPage();
		log.info("Login Page - Verify Login Page is displayed");
		verifyTrue(loginPage.isLoginPageDisplayed());
		// verifyFalse(loginPage.isLoginPageDisplayed());
		log.info("Login Page - Input to Email textbox");
		System.out.println(EMAIL);
		loginPage.inputtoDynamicTextbox("Email", EMAIL);

		System.out.println("Login Page - Input to Password textbox");
		loginPage.inputtoDynamicTextbox("Password", PASSWORD);

		System.out.println("Login Page - Click to Login Button -> Navigate to HomePage");
		homePage = loginPage.clickToLoginButton();

		System.out.println("Home Page -> Verify 'My Account' and 'Logout' Link Displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		verifyTrue(homePage.isLogoutLinkDisplayed());
		// verifyFalse(homePage.isLogoutLinkDisplayed());
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
		closeBrowserAndDriver(driver);
	}
}
