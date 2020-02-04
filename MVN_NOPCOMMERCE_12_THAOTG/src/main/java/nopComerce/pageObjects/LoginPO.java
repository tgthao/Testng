package nopComerce.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import nopComerce.pageUIs.LoginPageObjectUI;

public class LoginPO extends AbstractPageObject{
	WebDriver driverGlobal;
	

	public LoginPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		driverGlobal = driver;
	}

	public void inputToEmailTextbox(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(LoginPageObjectUI.LOGIN_EMAIL);
		sendKeyToElement(LoginPageObjectUI.LOGIN_EMAIL, value);
	}

	public HomePO clickToLoginButton() {
		// TODO Auto-generated method stub
		waitToElementVisible(LoginPageObjectUI.LOGIN_BUTTON);
		clickToElement(LoginPageObjectUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driverGlobal);
		
	}

	public void inputPasswordTextbox(String value) {
		// TODO Auto-generated method stub
		waitToElementVisible(LoginPageObjectUI.LOGIN_PASSWORD);
		sendKeyToElement(LoginPageObjectUI.LOGIN_PASSWORD, value);
	}

	public boolean isLoginPageDisplayed() {
		// TODO Auto-generated method stub
		waitToElementVisible(LoginPageObjectUI.LOGIN_FORM);
		return isElementDisplayed(LoginPageObjectUI.LOGIN_FORM);
	}

	public boolean verifyWrongEmail(String containsMessage) {
		waitToElementVisible(LoginPageObjectUI.LOGIN_NO_CUSTOMER_ERROR,containsMessage);
		return isElementDisplayed(LoginPageObjectUI.LOGIN_NO_CUSTOMER_ERROR, containsMessage);
		
	}

}
