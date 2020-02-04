package nopComerce.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class SearchPO extends AbstractPageObject{
WebDriver driverGlobal;
	public SearchPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		driverGlobal = driver;
	}
}
