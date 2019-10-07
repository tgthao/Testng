package Dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterWithTestNGXML {
	WebDriver driver;
	@Test
	@Parameters({"author","searchKey"})
	public void testParamaterWithXML(@Optional("ABC")String author, String seachKey)
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(seachKey);
		System.out.println("Welcome -> "+author+"Your seach key is -> "+seachKey);
		System.out.println("Thread will sleap now");
		System.out.println("Value in Google Seach Box"+searchText.getText()+" :: Value given by input = "+seachKey);
		AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(seachKey));
		driver.quit();
	}
}
