
package com.nopcommerce.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;


public class Level_15_Upgrade_Enviroment extends AbstractTest{

	AbstractPage abstractPage;
	String email;
	private WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = OpenMultiBrowsers(browserName);
		
		driver.get("https://demo.nopcommerce.com");
		///printBrowserConsoleLogs(driver);
	}



	@Test
	public void TC_01_Register() {

		
		
	}


	@AfterClass
	public void quit() {
		driver.quit();
	}
}
