 package com.nopcommerce.payment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Level_01_Step_By_Step {
	WebDriver driver;
	Select select;
	String email;
  
  @BeforeClass
   public void beforeClass() {
	//  String rootFolder = System.getProperty("user.dir");
	  String OS = System.getProperty("os.name").toLowerCase();

		if(OS.contains("mac")) {
			//System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
			//driver = new ChromeDriver();
			driver = new SafariDriver();
			driver.manage().window().maximize();
		}
		else {
			System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
	 
	  email = "giang_thao"+randomNumber()+"@hotmail.com";
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
	  }
  @Test
  public void TC_01_Register() {
	  //Click to Register Page
	  driver.findElement(By.xpath("//a[@class='ico-register']")).click();
	  //Verify Register Page display
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page registration-page']")).isDisplayed());
	 
	  // Click to Gender radio Button
	  driver.findElement(By.xpath("//input[@id='gender-female']")).click();
	  //Input to FirstName Textbox
	  driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Thao");;
	  //Input to LastName Textbox
	  driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Giang");;
	  //Select Date of Birth dropdown
	  select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
	  select.selectByVisibleText("10");
	  select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
	  select.selectByVisibleText("October");
	  select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
	  select.selectByVisibleText("1999");
	  //Input to Email Textbox
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
	  //Input to Company Textbox
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("MASCO123");
	  //Input to Company Textbox
	  driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("MASCO123");
	  //Click to Register Button
	  driver.findElement(By.xpath("//input[@id='register-button']")).click();
	  //Verify successfully Register
	  //Verify Register Page display
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='result' and text()='Your registration completed']")).isDisplayed());
	  //click to Logout Page
	  driver.findElement(By.xpath("//a[contains(.,'Log out')]")).click();
	  //Verify navigate to Home Page Success
	  Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
	  
	  
	  
  }
  @Test
  public void TC_02_Login() {
	
	  driver.findElement(By.xpath("//a[@class='ico-login']")).click();
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("MASCO123");
	  driver.findElement(By.xpath("//input[@class='button-1 login-button' and @value='Log in']")).click();
	  
  }

  
 

  @AfterClass
  public void afterClass() {
  }
  
  public int randomNumber() {
	  Random random = new Random();
	  return random.nextInt(99999);
  }

}
