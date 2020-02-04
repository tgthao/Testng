package com.nopcomerce.frontend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import driverfactoryPattern.DriverManager;
import driverfactoryPattern.DriverManagerFactory;
import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.PageGeneratorManager;
import nopComerce.pageObjects.RegisterPO;


public class FE_01_Register {
	private DriverManager driverManager;
	private HomePO homePage;
	private RegisterPO registerPage;
	public WebDriver driver;
	AbstractPage abstractPage;
	String email;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
		System.out.println(driverManager.toString());
		driver = driverManager.getDriver();
		System.out.println(driver.toString());
		abstractPage = new AbstractPage();
		email = "giang_thao" + abstractPage.randomNumber() + "@hotmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://demo.nopcommerce.com");
	}
	
	public void TC() {
		//System.out.println(driver.toString());
	}
	
	public void TC_01_RegisterEmptyData() {
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = homePage.openRegisterPage();
		abstractPage = new AbstractPage();
		abstractPage.sleepInSecond(1);
		registerPage.clickToRegisterButton();
		registerPage.isErrorMessageRegister("FirstName", "First name is required.");
		registerPage.isErrorMessageRegister("LastName", "Last name is required.");
		registerPage.isErrorMessageRegister("Email", "Email is required.");
		registerPage.isErrorMessageRegister("Password", "Password is required.");
		registerPage.isErrorMessageRegister("ConfirmPassword", "Password is required.");
	}

	public void TC_02_RegisterInvalidEmail() {
		homePage = PageGeneratorManager.getHomePage(driver);
		abstractPage = new AbstractPage();
		
		registerPage = homePage.openRegisterPage();
		abstractPage.sleepInSecond(2);
		registerPage.clickToMaleRadioButton();

		registerPage.inputToFirstNameTextbox("Thao");
		registerPage.inputToLastNameTextbox("Giang");
		registerPage.inputToEmailTextbox("abc");
		registerPage.isErrorMessageRegister("Email", "Wrong email");
		registerPage.inputToPassWordTextbox("Masco123");
		registerPage.inputToConfirmPassWordTextbox("Masco123");
		
	}

	public void TC_03_RegisterWithExistingEmail() {
		homePage = PageGeneratorManager.getHomePage(driver);
		abstractPage = new AbstractPage();
		
		registerPage = homePage.openRegisterPage();
		abstractPage.sleepInSecond(4);
		registerPage.clickToMaleRadioButton();

		registerPage.inputToFirstNameTextbox("Thao");
		registerPage.inputToLastNameTextbox("Giang");
		registerPage.inputToEmailTextbox("thaogiang.90@gmail.com");
		registerPage.inputToPassWordTextbox("Masco123");
		registerPage.inputToConfirmPassWordTextbox("Masco123");
		registerPage.clickToRegisterButton();
		registerPage.isDisplayedMessageExistingdEmail();
	}
	
	public void TC_04_RegisterlescharacPassword() {
		driver.get("https://demo.nopcommerce.com");
		homePage = PageGeneratorManager.getHomePage(driver);
		abstractPage = new AbstractPage();
		
		registerPage = homePage.openRegisterPage();
		abstractPage.sleepInSecond(4);
		registerPage.clickToMaleRadioButton();

		registerPage.inputToFirstNameTextbox("Thao");
		registerPage.inputToLastNameTextbox("Giang");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPassWordTextbox("Masco");
		registerPage.inputToConfirmPassWordTextbox("Masco");
		//registerPage.isErrorMessageRegister("Password", "must have at least 6 characters");
				
		//System.out.println(abstractPage.getTextElement("//span[@id='Password-error']"));
		registerPage.clickToRegisterButton();
		//span[@id='Password-error']//li
			//span[@id='Password-error']//ul/li
	}
	
	public void TC_05_REgisternotMatchPasswordConfirm() {
		driver.get("https://demo.nopcommerce.com");
		homePage = PageGeneratorManager.getHomePage(driver);
		abstractPage = new AbstractPage();
		
		registerPage = homePage.openRegisterPage();
		abstractPage.sleepInSecond(4);
		registerPage.clickToMaleRadioButton();

		registerPage.inputToFirstNameTextbox("Thao");
		registerPage.inputToLastNameTextbox("Giang");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPassWordTextbox("Masco123");
		registerPage.inputToConfirmPassWordTextbox("Masco");
		registerPage.clickToRegisterButton();
		registerPage.isErrorMessageRegister("ConfirmPassword", "The password and confirmation password do not match.");
		
	}
	@Test
	public void TC_06_RegistervalidInfor() {
		driver.get("https://demo.nopcommerce.com");
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
		registerPage.isDisplayedLogOutLink();
		abstractPage.sleepInSecond(3);
		registerPage.isDisplayedLogOutLink();
		homePage = registerPage.clicktoLogOutButton();
		System.out.println(driver.toString());
		abstractPage.sleepInSecond(3);
	}
	

}
