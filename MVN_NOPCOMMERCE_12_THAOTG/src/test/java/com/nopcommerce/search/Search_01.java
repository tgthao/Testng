
package com.nopcommerce.search;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcomerce.common.Common_01_RegisterToSystem;

import commons.AbstractPageObject;
import commons.AbstractTest;
import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.LoginPO;
import nopComerce.pageObjects.PageGeneratorManager;


public class Search_01 extends AbstractTest {
	private HomePO homePage;
	private LoginPO loginPage;
	private WebDriver driver;
	private AbstractPageObject abstractPage;
	String email, password;
	// private WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = OpenMultiBrowsers(browserName);
		

		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Precondition - Step 01 : Click to Login Link");
		loginPage = homePage.openLoginPage();
		
		log.info("Precondition - Step 02 : Verify Login Page is displayed");
		verifyTrue(loginPage.isLoginPageDisplayed());
		
		
		log.info("Login Page - Input to Email textbox");
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.EMAIL);
		loginPage.inputPasswordTextbox(Common_01_RegisterToSystem.PASSWORD);

		log.info("Login Page - Click to Login Button -> Navigate to HomePage");
		homePage = loginPage.clickToLoginButton();

		log.info("Home Page -> Verify 'My Account' and 'Logout' Link Displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		verifyTrue(homePage.isLogoutLinkDisplayed());
		//verifyFalse(homePage.isLogoutLinkDisplayed());
		abstractPage = new AbstractPageObject(driver);
		abstractPage.sleepInSecond(2);
		
	}
	@Test
	public void TC_01_SearchWithName() {
		System.out.println("TTC_01_SearchWithName");
	}
	@Test
	public void TC_02_SSearchCategory() {
		System.out.println("TC_02_SSearchCategory");
	}
	@Test
	public void TC_03_Manufactory() {
		System.out.println("TC_03_Manufactory");
	}
	@AfterClass
	public void quit() {
		driver.quit();
	}
}
