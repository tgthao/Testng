package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;

public class LoginFactory extends AbstractPageFactory {
	public LoginFactory(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.ID, using ="Email")
	private WebElement emailTextbox;
	@FindBy(how = How.ID, using ="Password")
	private WebElement passwordTextbox;
	@FindBy(how = How.CSS, using =".login-button")
	private WebElement loginButton;
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(emailTextbox);
		sendkeyToElement(emailTextbox, email);
	}
	public void inputPasswordTextbox(String password) {
		waitToElementVisible(passwordTextbox);
		sendkeyToElement(passwordTextbox, password);
	}
	public void clickToLoginButton() {
		waitToElementVisible(loginButton);
		loginButton.click();
	}
	
}
