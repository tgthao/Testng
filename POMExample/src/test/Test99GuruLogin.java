package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pages.Guru99HomePage;
import pages.Guru99Login;

public class Test99GuruLogin {
	WebDriver driver;
	Guru99HomePage objHomepage;
	Guru99Login objLogin;
	@BeforeTest
	public void settup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
		//mngr219953
		//zYtejYb
	}
	/**

     * This test case will login in http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message

     */
	@Test(priority=0)
	public void test_Home_Page_Appear_Correct() {
		//Create Login Page Object
		objLogin = new Guru99Login(driver);
		//Verify login page title
		String loginPageTitle = objLogin.getLoginTitle();
		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		//Login to application
		objLogin.loginToGuru99("mngr219953", "zYtejYb");
		//Go the next page
		objHomepage  = new Guru99HomePage(driver);
		//Verify Home page
		Assert.assertTrue(objHomepage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr219953"));
	}
}
