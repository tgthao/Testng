package setPreference;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class setPreference {
	WebDriver driver;
	
	@Test
	public void testExamples() {
		driver = new FirefoxDriver();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.statup.hompage", "http://google.com.vn");
		driver = new FirefoxDriver(profile);
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("100");
	}
	
	
}
