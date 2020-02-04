package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankGuru.pageUIs.LoginPageUI;
import commons.AbstractPageObject;


public class LoginPO extends AbstractPageObject {
	WebDriver driverGlobal;

	public LoginPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		driverGlobal = driver;
	}

	public String getLoginPageUrl() {
		// TODO Auto-generated method stub
		return getCurrentPageURL();
	}

	public RegisterPO clickToHereLink() {
		// TODO Auto-generated method stub
		waitToElementVisible(LoginPageUI.HERE_LINK);
		clickToElement(LoginPageUI.HERE_LINK);
		return BankGuruPageGeneratorManager.getRegisterPO(driverGlobal);
	}

	public void inputToUserIDTextbox(String userID) {
		waitToElementVisible(LoginPageUI.USER_ID_TEXTBOX);
		sendKeyToElement(LoginPageUI.USER_ID_TEXTBOX, userID);

	}

	public void inputToPasswordTextbox(String passWord) {
		waitToElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(LoginPageUI.PASSWORD_TEXTBOX, passWord);

	}

	public HomePagePO clickToSubmitButton() {
		// TODO Auto-generated method stub
		waitToElementVisible(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return BankGuruPageGeneratorManager.getHomePage(driverGlobal);
	}

}
