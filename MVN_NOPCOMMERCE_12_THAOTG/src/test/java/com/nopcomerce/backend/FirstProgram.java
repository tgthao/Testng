package com.nopcomerce.backend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "/Volumes/SPRING/workspace/POM_NOPCOMMERCE_12_THAOTG/resources/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");

	}

}
