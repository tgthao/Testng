package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99Login {
	WebDriver driver;
	/**
	 * All Webelements are identified by @FindBy annotation
	 */
	@FindBy(name="uid")
	WebElement user99GuruName;
	@FindBy(name="password")
	WebElement password99Guru;
	@FindBy(className="barone")
	WebElement titleText;
	@FindBy(name="btnLogin")
	WebElement login;
	public Guru99Login(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	//Set username in text box
	public void setUserName(String strUserName) {
		user99GuruName.sendKeys(strUserName);
	}
	//Set password in text box
	public void setPassWord(String strPassWord) {
		password99Guru.sendKeys(strPassWord);
	}
	//Click Login button
	public void clickLogin() {
		login.click();
	}
	//Get the title of Login page
	public String getLoginTitle() {
		return titleText.getText();
	}
	/**
	 * This POM method will exposed in test case to login in the applicaion
	 * @param strUserName
	 * @param strPassWord
	 * @return
	 */
	public void loginToGuru99(String strUserName,String strPassWord) {
		//Fill User Name
		this.setUserName(strUserName);
		//Fill Pass Word
		this.setPassWord(strPassWord);
		//Click Login button
		this.clickLogin();
		
	}
}
