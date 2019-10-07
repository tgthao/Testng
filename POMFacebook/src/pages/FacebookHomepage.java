package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookHomepage {
	private WebDriver driver;
	private By byUserNavigation = By.id("userNavigationLabel");
	public FacebookHomepage(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isDisplayed() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(driver.findElement(byUserNavigation).isDisplayed()) {
			return true;
		}
		return false;
	}
}
