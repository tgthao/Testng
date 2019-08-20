package firsttestngpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class firsttestngfile {
	String baseUrl = "";
	WebDriver driver;
	@BeforeClass
	public void lauchBrowser() {
		System.out.print("Lauching firefox browser");
		driver = new FirefoxDriver();
		driver.get(baseUrl);
	}
	@Test
	public void verifyHomepageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@AfterClass
	public void terminateBrowser() {
		driver.close();
	}
}
