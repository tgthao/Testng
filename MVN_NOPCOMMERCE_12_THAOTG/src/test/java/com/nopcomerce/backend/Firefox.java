package com.nopcomerce.backend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Firefox {
	@BeforeClass
	public void openBrowser() {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
	}

	@Test
	public void f() {
	}
}
