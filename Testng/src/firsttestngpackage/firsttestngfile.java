package firsttestngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class firsttestngfile {
	String baseUrl = "http://demo.guru99.com/test/newtours/";
	WebDriver driver;
	 public String expected = null;
	 public String actual = null;
	@BeforeClass
	public void lauchBrowser() {
		System.out.print("Lauching firefox browser");
		driver = new FirefoxDriver();
		driver.get(baseUrl);
	}
	@BeforeMethod
	public void verifyHomepageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test(priority = 0)
	public void register() {
		driver.findElement(By.linkText("REGISTER")).click();
		expected = "Register: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 1)
	public void support() {
		driver.findElement(By.linkText("SUPPORT")).click() ;
        expected = "Under Construction: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
	}
	@AfterMethod
    public void goBackToHomepage ( ) {
          driver.findElement(By.linkText("Home")).click() ;
    }
	@AfterClass
	public void terminateBrowser() {
		driver.close();
	}
}
