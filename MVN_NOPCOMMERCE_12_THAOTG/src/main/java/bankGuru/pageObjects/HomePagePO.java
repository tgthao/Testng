package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankGuru.pageUIs.HomePageUI;
import commons.AbstractPageObject;

public class HomePagePO extends AbstractPageObject{
	WebDriver driverGlobal;
	

	public HomePagePO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		driverGlobal = driver;
	}


	public boolean isWelcomeMessageDisplayed() {
		waitToElementVisible(HomePageUI.WELCOME_MESSAGE);
		return isElementDisplayed(HomePageUI.WELCOME_MESSAGE);
	}




	
}
