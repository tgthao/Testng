package com.nopcomerce.java;

import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Java_TC_02 {
	WebDriver driver;
	Actions action;
	long shortTimeout = 5;
	long longTimeout = 30;
	WebDriverWait waitExplicit;
	Date date;
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-infobars");
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
	  
	  action = new Actions(driver);
	  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	  driver.get("https://demo.nopcommerce.com/");
  }
  @Test
  public void TC_01() throws InterruptedException {
	  //Step 01 Check login Page Displayed
	  boolean loginPageStatus = isElementDisplayed("//a[@class='ico-login']");
	  System.out.println("Login page "+loginPageStatus);
	  Assert.assertTrue(loginPageStatus);
	  //Step 02 - Check Mini Cart un-displayed (leave mouse)
	  boolean miniCartUnStatus = isElementDisplayed("");
	  System.out.println("Mini Cart "+miniCartUnStatus);
	  Assert.assertTrue(miniCartUnStatus);
	  //Step 03 - Check run cart displayed
	  action.moveToElement(driver.findElement(By.xpath("//a[@class='ico-cart']")));
	  Thread.sleep(3000);
	  boolean miniCartDisplayedStatus = isElementDisplayed("//div[@class='ico-count']");
	  System.out.println("Mini Cart = "+miniCartDisplayedStatus);
	  Assert.assertTrue(miniCartDisplayedStatus);
	  
	  //==== ELEMENT KHONG CO TRONG DOM =========//
	  
	  //Step 04 - Check my Account Page un-displayed
	  System.out.println("Before: "+getDateTime());
	  waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@class='ico-account']")));
	  System.out.println("After: "+getDateTime());
	  
	  boolean myAccountPage = isElementDisplayed("//a[@class='ico-account']");
	  System.out.println("My Account Page = "+myAccountPage);
	  Assert.assertTrue(myAccountPage);
	  Assert.assertTrue(isElementDisplayed("//a[@class='ico-account']"));
	  
	  //Step 05 - Open Login Page -> Check Nivo Image Un-displayed
	  driver.findElement(By.xpath("//a[@class='ico-login']")).click();
	  boolean nivoImageStatus = isElementDisplayed("//a[@class='nivo-imageLink']");
	  System.out.println("Nivo Image = "+nivoImageStatus);
	  Assert.assertTrue(isControlUndisplayed("//a[@class='nivo-imageLink']"));
  }
  public boolean isElementDisplayed(String locator) {
	  try {
		  WebElement elment = driver.findElement(By.xpath(locator));
		  return elment.isDisplayed();
		  
	  }
	  catch (NoSuchElementException e) {
		// TODO: handle exception
		  return false;
	}
  }
  public boolean isControlUndisplayed(String locator) {
	  Date date = new Date();
	  System.out.println("Start time = " + date.toString());
	  List <WebElement> elements = driver.findElements(By.xpath(locator));
	  if(elements.size()==0) {
		  System.out.println("Element not in DOM");
		  System.out.println("End time = "+new Date().toString());
		  return true;
	  } else if (elements.size()>0 &&! elements.get(0).isDisplayed()) {
		System.out.println("Element in DOM but not visible/ displayed ");
		System.out.println("End time = "+new Date().toString());
		return true;
	} else  {
		System.out.println("Element in DOM and visible");
		return false;
	}
  }
  public String getDateTime() {
	  Date date = new Date();
	  return date.toString();
  }

  @AfterClass
  public void quit() {
	  
  }
}
