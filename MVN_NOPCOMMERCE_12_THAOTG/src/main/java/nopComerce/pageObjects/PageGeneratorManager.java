package nopComerce.pageObjects;


import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	WebDriver driver;
	
	public static HomePO getHomePage(WebDriver driver) {
		return  new HomePO(driver);
	}
	public static RegisterPO getRegisterPage(WebDriver driver) {
		return  new RegisterPO(driver);
	}
	public static LoginPO getLoginPage(WebDriver driver) {
		return  new LoginPO(driver);
	}
	public static HeaderMyAccountPO getHeaderMyAccountPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new HeaderMyAccountPO(driver);
	}
	public static SitemapPO getSitemapPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new SitemapPO(driver);
	}
	public static SearchPO getSearchPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new SearchPO(driver);
	}
	public static FooterMyAccountPO getFooterMyAccountPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new FooterMyAccountPO(driver);
	}
	public static ShippingAndReturnPO getShippingAndReturnPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new ShippingAndReturnPO(driver);
	}
	
}
