
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


public class Level_11_Assert_Verify extends AbstractTest {
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
	}
	@Test
	public void TC_01_Register() {
		log.info("TC_01_Register-Homepage - Click to Register Link");
		registerPage = homePage.openRegisterPage();
		System.out.println("Register Page - Verify Register is displayed");
		verifyTrue(registerPage.isRegisterPageDisplayed());
		verifyFalse(registerPage.isRegisterPageDisplayed());
		abstractPage.sleepInSecond(4);
		System.out.println("Register Page - Click to Gender radio button");
		registerPage.clickToMaleRadioButton();
		System.out.println("Register Page - Input to Firstname textbox");
		registerPage.inputToFirstNameTextbox("Thao");
		System.out.println("Register Page - Input to Lastname textbox");
		registerPage.inputToLastNameTextbox("Giang");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPassWordTextbox(password);
		registerPage.inputToConfirmPassWordTextbox(password);
		registerPage.clickToRegisterButton();
		assertEquals(registerPage.getSuccessMessageText(),"Your registration completed");
		abstractPage.sleepInSecond(3);
		registerPage.isDisplayedLogOutLink();
		homePage = registerPage.clicktoLogOutButton(); // abc
		System.out.println(driver.toString());
		abstractPage.sleepInSecond(3);
	}
	@Test
	public void TC_02_Login() {
		System.out.println("Home Page - Click to Login Link");
		loginPage = homePage.openLoginPage();
		System.out.println("Login Page - Verify Login Page is displayed");
		verifyTrue(loginPage.isLoginPageDisplayed());
		//verifyFalse(loginPage.isLoginPageDisplayed());
		System.out.println("Login Page - Input to Email textbox");
		loginPage.inputToEmailTextbox("giang_thao57044@hotmail.com");

		System.out.println("Login Page - Input to Password textbox");
		loginPage.inputPasswordTextbox("Masco123");

		System.out.println("Login Page - Click to Login Button -> Navigate to HomePage");
		homePage = loginPage.clickToLoginButton();

		System.out.println("Home Page -> Verify 'My Account' and 'Logout' Link Displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		verifyTrue(homePage.isLogoutLinkDisplayed());
		//verifyFalse(homePage.isLogoutLinkDisplayed());
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
