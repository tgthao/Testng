package bankGuru.pageUIs;

public class HomePageUI {
	public static final String WELCOME_MESSAGE = "//marquee[@class='heading3' and text()=\"Welcome To Manager's Page of Guru99 Bank\"]";
	//Dynamic Home Page
	public static final String DYNAMIC_ELEMENT_SIDEBAR = "//a[text()='%s']";
	public static final String SUBMIT_BUTTON ="//input[@name='AccSubmi";
	public static final String RESET_BUTTON ="//input[@name='res']";
	//a[@class='dropdown-toggle' and contains(text(),'Selenium')]
	//td[contains(text(),'Customer ID')]/parent::tr/td/input
	//Dynamic Element Component 
	public static final String DYNAMIC_ELEMENT_TEXTBOX ="//td[contains(text(),'%s')]/parent::tr/td/input";
}
