package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	private By byEmail = By.id("email");
	private By byPass = By.id("pass");
	private By byBtnLogin = By.id("u_0_a");
	public LoginPage(WebDriver driver) {
		this.driver  = driver;
	}
	public void LoginFacebook(String strUserName,String strPassWord) {
		driver.findElement(byEmail).sendKeys(strUserName);
		driver.findElement(byPass).sendKeys(strPassWord);
		driver.findElement(byBtnLogin).click();
		
	}
}
