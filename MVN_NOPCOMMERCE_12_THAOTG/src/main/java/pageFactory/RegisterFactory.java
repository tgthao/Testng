package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;
import nopComerce.pageUIs.RegisterPageUI;

public class RegisterFactory extends AbstractPageFactory{
	public RegisterFactory(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.ID, using ="gender-female")
	private WebElement genderMaleRadioButton;
	@FindBy(how = How.ID, using ="FirstName")
	private WebElement firstNameTextbox;
	@FindBy(how = How.ID, using ="LastName")
	private WebElement lastnameTextbox;
	@FindBy(how = How.ID, using ="Email")
	private WebElement emailTextbox;
	@FindBy(how = How.ID, using ="Password")
	private WebElement passwordTextbox;
	@FindBy(how = How.ID, using ="ConfirmPassword")
	private WebElement confirmpasswordTextbox;
	@FindBy(how = How.ID, using ="register-button")
	private WebElement registerButton;
	@FindBy(how = How.XPATH, using ="//div[@class='result' and text()='Your registration completed']")
	private WebElement registerSuccessMessage;
	@FindBy(how = How.CSS, using =".result")
	private WebElement registerSuccessText;
	@FindBy(how = How.CSS, using =".ico-logout")
	private WebElement logoutLink;
	public void clickToMaleRadioButton() {
		waitToElementVisible(genderMaleRadioButton);
		clickToElement(genderMaleRadioButton);
		
	}

	public void inputToEmailTextbox(String emailValue) {
		waitToElementVisible(emailTextbox);
		sendkeyToElement(emailTextbox, emailValue);
	}

	

	public void inputToFirstNameTextbox(String firstNameValue) {
		waitToElementVisible(firstNameTextbox);
		sendkeyToElement(firstNameTextbox, firstNameValue);
	}

	public void inputToLastNameTextbox(String lastNameValue) {
		waitToElementVisible(lastnameTextbox);
		sendkeyToElement(lastnameTextbox, lastNameValue);
		
	}
	public void inputToPassWordTextbox(String passWordTextbox) {
		waitToElementVisible(passwordTextbox);
		sendkeyToElement(passwordTextbox, passWordTextbox);
		
	}
	public void inputToConfirmPassWordTextbox(String passWordValue) {
		waitToElementVisible(confirmpasswordTextbox);
		sendkeyToElement(confirmpasswordTextbox, passWordValue);
	}

	public void clickToRegisterButton() {
		waitToElementVisible(registerButton);
		registerButton.click();
	}

	public boolean isDisplayedMessage() {
		waitToElementVisible(registerSuccessMessage);
		return registerSuccessMessage.isDisplayed();
		
		
	}

	public boolean isDisplayedLogOutLink() {
		waitToElementVisible(logoutLink);
		return logoutLink.isDisplayed();
		
	}

	public void clicktoLogOutButton() {
		waitToElementVisible(logoutLink);
		logoutLink.click();
	}
	public String getSuccessMessageText() {
		return getTextElement(registerSuccessText);
	}

}
