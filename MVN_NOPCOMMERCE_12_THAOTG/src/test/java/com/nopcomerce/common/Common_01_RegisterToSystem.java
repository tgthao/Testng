
package com.nopcomerce.common;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPageObject;
import commons.AbstractTest;
import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.PageGeneratorManager;
import nopComerce.pageObjects.RegisterPO;


public class Common_01_RegisterToSystem extends AbstractTest {
	private HomePO homePage;
	private RegisterPO registerPage;
	private WebDriver driver;
	private AbstractPageObject abstractPage;
	public static String EMAIL, PASSWORD;
	// private WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = OpenMultiBrowsers(browserName);
		abstractPage = new AbstractPageObject(driver);
		EMAIL = "giang_thao" + randomNumber() + "@hotmail.com";
		PASSWORD ="AutomationTesting";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage = PageGeneratorManager.getHomePage(driver);log.info("TC_01_Register-Homepage - Click to Register Link");
		
		
	}
	@Test
	public void TC_01_Register() {
		log.info("Precondition - Step 01: Click to Register Link");
		registerPage = homePage.openRegisterPage();
		
		log.info("Precondition - Step 02: Verify Register is displayed");
		verifyTrue(registerPage.isRegisterPageDisplayed());
		
		log.info("Precondition - Step 03: Input all data required fields");
		abstractPage.sleepInSecond(1);
		
		log.info("Register Page - Click to Gender radio button");
		registerPage.clickToMaleRadioButton();
		
		log.info("Register Page - Input to Firstname textbox");
		registerPage.inputToFirstNameTextbox("Thao");
		
		log.info("Register Page - Input to Lastname textbox");
		registerPage.inputToLastNameTextbox("Giang");
		registerPage.inputToEmailTextbox(EMAIL);
		registerPage.inputToPassWordTextbox(PASSWORD);
		registerPage.inputToConfirmPassWordTextbox(PASSWORD);
		registerPage.clickToRegisterButton();
		
		log.info("Precondition - Step 04: Verify success message correct");
		assertEquals(registerPage.getSuccessMessageText(),"Your registration completed");
		abstractPage.sleepInSecond(3);
		registerPage.isDisplayedLogOutLink();
		System.out.println(driver.toString());
		abstractPage.sleepInSecond(3);
		
	}
	

	@AfterClass
	public void quit() {
		driver.quit();
	}
}
