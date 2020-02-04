package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;
import nopComerce.pageUIs.HomePageUI;

public class HomePageFactory extends AbstractPageFactory{
	public HomePageFactory(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.CSS, using =".ico-register")
	private WebElement registerLink;
	@FindBy(how = How.CSS, using =".ico-login")
	private WebElement loginLink;
	@FindBy(how = How.CSS, using =".ico-account")
	private WebElement accountLink;
	@FindBy(how = How.CSS, using =".ico-logout")
	private WebElement logoutLink;
	public void clickToLoginLink() {
		// TODO Auto-generated method stub
		waitToElementVisible(loginLink);
		clickToElement(loginLink);
	}


	public boolean isDisplayedLoginLink() {
		// TODO Auto-generated method stub
		waitToElementVisible(loginLink);
		return isElementDisplayed(loginLink);
	}


	public void clickToLogoutButton() {
		// TODO Auto-generated method stub
		waitToElementVisible(logoutLink);
		clickToElement(logoutLink);
	}


	public void clickRegisterURL() {
		// TODO Auto-generated method stub
		waitToElementVisible(registerLink);
		clickToElement(registerLink);
	}
	public boolean isMyAccountLinkDisplsyed() {
		waitToElementVisible(accountLink);
		return isElementDisplayed(accountLink);
	}
	public boolean isDisplayedLogoutLink() {
		// TODO Auto-generated method stub
		waitToElementVisible(logoutLink);
		return isElementDisplayed(logoutLink);
	}
}
