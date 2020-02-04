
package com.nopcommerce.payment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.User_Module;

import commons.AbstractPageObject;
import commons.AbstractTest;
import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.LoginPO;
import nopComerce.pageObjects.PageGeneratorManager;
import nopComerce.pageObjects.RegisterPO;

public class Level_14_Data_Test_03_JavaClass extends AbstractTest {
	private HomePO homePage;
	private RegisterPO registerPage;
	private LoginPO loginPage;
	private WebDriver driver;
	private AbstractPageObject abstractPage;
	String email;
	// Declare variable
	
	// private WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = OpenMultiBrowsers(browserName);
		abstractPage = new AbstractPageObject(driver);

		homePage = PageGeneratorManager.getHomePage(driver);
		
		email = User_Module.Register.PRE_FIX_EMAIL + randomNumber() + User_Module.Register.POST_FIX_EMAIL;
		
	}

	@Test
	public void TC_01_Validate() {
		log.info("Validate- Step 01: - Click to Register Link");
		registerPage = homePage.openRegisterPage();
		log.info("Validate- Step 02: - Click to Register Button");
		registerPage.clickToDynamicButton("Register");
		log.info("Validate- Step 03: - Verify Error Message Displayed");
		verifyEquals(registerPage.getDynamicRequireFieldErrorMessage("FirstName"), User_Module.Validate.FIRST_NAME_ERROR);
		verifyEquals(registerPage.getDynamicRequireFieldErrorMessage("LastName"), User_Module.Validate.LAST_NAME_ERROR);
		verifyEquals(registerPage.getDynamicRequireFieldErrorMessage("Email"), User_Module.Validate.EMAIL_ERROR);
		verifyEquals(registerPage.getDynamicRequireFieldErrorMessage("Password"), User_Module.Validate.PASSWORD_ERROR);
		verifyEquals(registerPage.getDynamicRequireFieldErrorMessage("ConfirmPassword"),User_Module.Validate.PASSWORD_ERROR);

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
		registerPage.inputtoDynamicTextbox("FirstName", User_Module.Register.FIRST_NAME);
		log.info("Register Page - Input to Lastname textbox");
		registerPage.inputtoDynamicTextbox("LastName", User_Module.Register.LAST_NAME);
		registerPage.inputtoDynamicTextbox("Company", User_Module.Register.COMPANY_NAME);
		registerPage.inputtoDynamicTextbox("Email", email);
		registerPage.inputtoDynamicTextbox("Password", User_Module.Register.PASSWORD);
		registerPage.inputtoDynamicTextbox("ConfirmPassword", User_Module.Register.PASSWORD);
		registerPage.clickToDynamicButton("Register");

		log.info("Precondition - Step 04: Verify success message correct");
		assertEquals(registerPage.getSuccessMessageText(), User_Module.Register.REGISTER_SUCCESS_MESSAGE);
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
		System.out.println(email);
		loginPage.inputtoDynamicTextbox("Email", email);

		System.out.println("Login Page - Input to Password textbox");
		loginPage.inputtoDynamicTextbox("Password", User_Module.Register.PASSWORD);

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
