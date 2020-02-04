package nopComerce.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import nopComerce.pageUIs.LoginPageObjectUI;

public class LoginPageObject extends AbstractPageObject{

	public LoginPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void inputToEmailTextbox(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(LoginPageObjectUI.LOGIN_EMAIL);
		sendKeyToElement(LoginPageObjectUI.LOGIN_EMAIL, value);
	}

	public void clickToLoginButton() {
		// TODO Auto-generated method stub
		waitToElementVisible(LoginPageObjectUI.LOGIN_BUTTON);
		clickToElement(LoginPageObjectUI.LOGIN_BUTTON);
		
	}

	public void inputPasswordTextbox(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(LoginPageObjectUI.LOGIN_PASSWORD);
		sendKeyToElement(LoginPageObjectUI.LOGIN_PASSWORD, value);
	}

}
