package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.FacebookHomepage;
import pages.LoginPage;

public class TestLoginFacebook {
	WebDriver driver;
	FacebookHomepage fbhomepage;
	LoginPage lgpage;
	@BeforeTest
	public void settup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		//mngr219953
		//zYtejYb
	}
	@Test(priority=0)
	public void Test() {
	//Create login page Object	
	fbhomepage = new FacebookHomepage(driver);
	lgpage = new LoginPage(driver);
	lgpage.LoginFacebook("0917637262", "");
	if(fbhomepage.isDisplayed()) {
		System.out.println("Login Successfully");
	}
	else 
		System.out.println("fail");
	}
	
}
