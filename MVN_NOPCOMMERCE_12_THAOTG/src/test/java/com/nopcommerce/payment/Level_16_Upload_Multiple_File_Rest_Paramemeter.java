package com.nopcommerce.payment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import nopComerce.pageUIs.AbstractPageNopCommerceUI;


public class Level_16_Upload_Multiple_File_Rest_Paramemeter extends AbstractTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String seleniumFileName = "Selenium.jpg";
	String appiumFileName = "Appium.jpg";
	String specflowFileName = "Specflow.jpg";

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void beforeClass(String browserName) {
		driver = OpenMultiBrowsers(browserName);
	}

	@Test
	public void TC_01_Sendkeys() throws Exception {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		// Upload 1 file
		uploadMultipleFiles(seleniumFileName);
		Thread.sleep(3000);

		// Verify
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + seleniumFileName + "')]")).isDisplayed());

		driver.navigate().refresh();

		// Upload 2 file
		uploadMultipleFiles(specflowFileName, appiumFileName);
		Thread.sleep(3000);

		// Verify
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + appiumFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + specflowFileName + "')]")).isDisplayed());

		driver.navigate().refresh();

		// Upload 3 file
		uploadMultipleFiles(seleniumFileName, specflowFileName, appiumFileName);
		Thread.sleep(3000);

		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + seleniumFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + appiumFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + specflowFileName + "')]")).isDisplayed());

	}

	public void uploadMultipleFiles(String... fileNames) {
		String filePath = System.getProperty("user.dir") + "\\uploadFile\\";
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}

		fullFileName = fullFileName.trim();
		driver.findElement(By.xpath(AbstractPageNopCommerceUI.UPLOAD_FILE_TYPE)).sendKeys(fullFileName);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}