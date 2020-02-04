package nopComerce.pageObjects;

import org.openqa.selenium.WebDriver;


import commons.AbstractPageObject;
import nopComerce.pageUIs.HomePageUI;

public class HomePO extends AbstractPageObject{
	public static String lastname = "";
	WebDriver driverGlobal;
	
	
	public HomePO(WebDriver driver) {
		
		super(driver);
		//lastname = "Giang Thao" + randomNumber();
		// TODO Auto-generated constructor stub
		driverGlobal = driver ;
		
		
	}



//
	public boolean isMyAccountLinkDisplayed() {
		// TODO Auto-generated method stub
		waitToElementVisible(HomePageUI.HEADER_ACCOUNT_LINK);
		return isElementDisplayed(HomePageUI.HEADER_ACCOUNT_LINK);
	}
	public HomePO clickToLogoutButton() {
		// TODO Auto-generated method stub
		waitToElementVisible(HomePageUI.HEADER_LOGOUT_LINK);
		clickToElement(HomePageUI.HEADER_LOGOUT_LINK);
		return new HomePO(driverGlobal);
	}


	public boolean isLogoutLinkDisplayed() {
		// TODO Auto-generated method stub
		waitToElementVisible(HomePageUI.HEADER_LOGOUT_LINK);
		return isElementDisplayed(HomePageUI.HEADER_LOGOUT_LINK);
		
	}
	public boolean isRegisterLinkUndisplayed() {
		waitToElementInvisible(HomePageUI.HEADER_REGISTER_LINK);
		return isElementDisplayed(HomePageUI.HEADER_REGISTER_LINK);
	}
	public boolean isLogInLinkdisplayed() {
		waitToElementVisible(HomePageUI.HEADER_LOGIN_LINK);
		return isElementDisplayed(HomePageUI.HEADER_LOGIN_LINK);
	}

}
