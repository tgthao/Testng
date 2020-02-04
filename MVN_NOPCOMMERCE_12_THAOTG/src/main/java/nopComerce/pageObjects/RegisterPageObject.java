package nopComerce.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import nopComerce.pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPageObject {
	
	

	public RegisterPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		
	}

	public void clickToMaleRadioButton() {
		waitToElementVisible(RegisterPageUI.GENDER_FEMALE_RADIO);
		clickToElement(RegisterPageUI.GENDER_FEMALE_RADIO);
		// TODO Auto-generated method stub
		
	}

	public void inputToEmailTextbox(String emailValue) {
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(RegisterPageUI.EMAIL_TEXTBOX, emailValue);
	}

	public void inputToPassWordTextbox(String passWordTextbox) {
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(RegisterPageUI.PASSWORD_TEXTBOX, passWordTextbox);
		
	}

	public void inputToFirstNameTextbox(String firstNameValue) {
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(RegisterPageUI.FIRST_NAME_TEXTBOX, firstNameValue);
	}

	public void inputToLastNameTextbox(String lastNameValue) {
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(RegisterPageUI.LAST_NAME_TEXTBOX, lastNameValue);
		
	}

	public void inputToConfirmPassWordTextbox(String passWordValue) {
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(RegisterPageUI.CONFIRM_TEXTBOX, passWordValue);
	}

	public void clickToRegisterButton() {
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.REGISTER_BUTTON);
		clickToElement(RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isDisplayedMessage() {
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.REGISTER_MESSAGE_SUCCESS);
		return isElementDisplayed(RegisterPageUI.REGISTER_MESSAGE_SUCCESS);
	}

	public boolean isDisplayedLogOutLink() {
		// TODO Auto-generated method stub
		
		waitToElementVisible(RegisterPageUI.LOGOUT_LINK);
		return isElementDisplayed(RegisterPageUI.LOGOUT_LINK);
	}

	public void clicktoLogOutButton() {
		// TODO Auto-generated method stub
		waitToElementVisible(RegisterPageUI.LOGOUT_LINK);
		clickToElement(RegisterPageUI.LOGOUT_LINK);
		
	}
	
}


