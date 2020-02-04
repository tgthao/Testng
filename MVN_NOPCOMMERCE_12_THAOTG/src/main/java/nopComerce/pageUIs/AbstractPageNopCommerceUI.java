package nopComerce.pageUIs;

public class AbstractPageNopCommerceUI {
	public static final String HEADER_REGISTER_LINK = "//a[@class='ico-register']";
	public static final String HEADER_LOGIN_LINK = "//a[@class='ico-login']";
	public static final String HEADER_LOGOUT_LINK = "//a[@class='ico-logout']";
	//Header (5 variable)
	public static final String HEADER_MY_ACCOUNT_LINK = "//a[@class='ico-account']";
	public static final String HEADER_WISHLIST_LINK = "//a[@class='ico-account']";
	public static final String HEADER_SHOPPING_CART_LINK = "//a[@class='ico-account']";
	public static final String HEADER_HOMEPAGE_LINK = "//div[@class='header-logo']//a//img";
	//FOOTER (23 VARIABLE)
	public static final String FOOTER_MY_ACCOUNT_LINK ="//div[@class='footer']//a[text()='My account']";
	public static final String FOOTER_SITE_MAP_LINK ="//div[@class='footer']//a[text()='Sitemap']";
	public static final String FOOTER_FOOTER_SHIPPING_AND_RETURN_LINK ="//div[@class='footer']//a[text()='Shipping & returns']";
	public static final String FOOTER_SEARCH_LINK ="//div[@class='footer']//a[text()='Search']";
	//Dynamic (page name) for footer
	
	public static final String DYNAMIC_FOOTERLINK ="//div[@class='footer']//a[text()='%s']";
	//Dynamic element component
	public static final String DYNAMIC_FOOTER_LINK ="//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_RADIO_BUTTON ="//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX ="//input[@id='%s']";
	public static final String DYNAMIC_TEXTAREA ="//textarea[@id='%s']";
	public static final String DYNAMIC_CHECKBOX ="//input[@id='%s']";
	public static final String DYNAMIC_BUTTON ="//input[@value='%s']";
	public static final String DYNAMIC_DROPDOWN_LIST ="//select[@name='%s']";
	public static final String DYNAMIC_REQUIRED_FIELD_ERROR_MESSAGE ="//span[@id='%s-error']";
	public static final String UPLOAD_FILE_TYPE="//input[@type='file']";
}
