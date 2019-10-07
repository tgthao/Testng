package ParameterByDataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class ParameterByDataProvider {
	WebDriver driver;
	@BeforeTest
	public void settup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
	}
	/**
	 * Test case to verify google search box
	 * @param author
	 * @param searchKey
	 * @throws InterruptedException
	 */
}
