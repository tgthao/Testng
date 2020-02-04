package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankGuru.pageUIs.RegisterPageUI;
import commons.AbstractPageObject;

public class RegisterPO extends AbstractPageObject{
	WebDriver driverGlobal;
	

	public RegisterPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		driverGlobal = driver;
	}


	public void inputToEmailIDTextbox(String email) {
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.EMAIL_ID_TEXTBOX);
		sendKeyToElement(RegisterPageUI.EMAIL_ID_TEXTBOX, email);
	}


	public HomePagePO clickToSubmitButton() {
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(RegisterPageUI.SUBMIT_BUTTON);
		return BankGuruPageGeneratorManager.getHomePage(driverGlobal);
	}


	public String getPasswordValue() {
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(RegisterPageUI.PASSWORD_TEXT);
		
	}


	public LoginPO openLoginPage(String loginPageUrl) {
		openURL(loginPageUrl);
		return BankGuruPageGeneratorManager.getLoginPage(driverGlobal);
	}


	public String getUserIDValue() {
		waitToElementVisible(RegisterPageUI.USER_ID_TEXT);
		return getTextElement(RegisterPageUI.USER_ID_TEXT);
		
	}




	
}
