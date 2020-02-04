package nopComerce.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;


public class HomePageObject extends AbstractPageObject{
	public static String lastname = "";
	
	
	public HomePageObject(WebDriver driver) {
		
		super(driver);
		lastname = "Giang Thao" + randomNumber();
		// TODO Auto-generated constructor stub
	}


	public void clickURL() {
		// TODO Auto-generated method stub
			
	}

//	public void clickToLoginLink() {
//		// TODO Auto-generated method stub
//		waitToElementVisible(HomePageUI.LOGIN_LINK);
//		clickToElement(HomePageUI.LOGIN_LINK);
//	}
//
//
//	public boolean isDisplayedLoginLink() {
//		// TODO Auto-generated method stub
//		waitToElementVisible(HomePageUI.LOGIN_LINK);
//		return isElementDisplayed(HomePageUI.LOGIN_LINK);
//	}
//
//
//	public void clickToLogoutButton() {
//		// TODO Auto-generated method stub
//		waitToElementVisible(HomePageUI.LOGOUT_LINK);
//		clickToElement(HomePageUI.LOGOUT_LINK);
//	}
//
//
//	public void clickRegisterURL() {
//		// TODO Auto-generated method stub
//		waitToElementVisible(HomePageUI.REGISTER_LINK);
//		clickToElement(HomePageUI.REGISTER_LINK);
//	}


}
