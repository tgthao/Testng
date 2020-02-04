package com.nopcommerce.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class driverfirefox {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "/Volumes/SPRING/workspace/POM_NOPCOMMERCE_12_THAOTG/resources/edge");
		driver = new EdgeDriver();	 
		driver.get("");
	}
  @Test
  public void f() {
  }
}
