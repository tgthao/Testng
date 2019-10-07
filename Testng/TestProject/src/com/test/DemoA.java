package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoA {
@Test
public void run() {
	WebDriver driver = new FirefoxDriver();
	Reporter.log("The Browser is opened now");
	driver.manage().window().maximize();
	Reporter.log("The browser is maximized");
	driver.get("https://www.google.com");
	Reporter.log("The google website is opened");
	driver.findElement(By.name("q")).sendKeys("Hi");
	Reporter.log("The data \"Hi\" is entered");
}
}
