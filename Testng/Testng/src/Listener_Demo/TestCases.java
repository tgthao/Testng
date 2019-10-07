package Listener_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener_Demo.ListenerTest.class)

public class TestCases {
	WebDriver driver = new FirefoxDriver();
	@Test
	public void Login() {
		driver.get("http://demo.guru99.com/V4/index.php");
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("aaa");
		driver.findElement(By.name("password")).sendKeys("bcd");
		driver.findElement(By.name("btnLogin")).click();
	}
	@Test
	public void TestToFail() {
		System.out.println("This method to test fail");
		Assert.assertTrue(false);
	}
	@AfterClass
	public void quit() {
		driver.quit();
	}
}
