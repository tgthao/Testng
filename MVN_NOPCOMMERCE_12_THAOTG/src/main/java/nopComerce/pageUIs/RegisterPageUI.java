package nopComerce.pageUIs;

public class RegisterPageUI {
	public static final String GENDER_FEMALE_RADIO = "//input[@id='gender-female']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String DAY_SELECTDROPDOWN = "//input[@id='LastName']";
	public static final String MONTH_SELECTDROPDOWN = "//input[@id='LastName']";
	public static final String YEAR_SELECTDROPDOWN = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//input[@id='register-button']";
	public static final String REGISTER_MESSAGE_SUCCESS = "//div[@class='result' and text()='Your registration completed']";
	public static final String LOGOUT_LINK = "//a[contains(.,'Log out')]";
	public static final String MYACCOUNT_LINK = "//a[@class='ico-account']";
	public static final String REGISTER_MESSAGE_EXIST_EMAIL = "//li[contains(text(),'The specified email already exists')]";
	public static final String INVALID_EMAIL = "//span[@id='Email-error']";
	public static final String FIRSTNAME_EMPTY = "//span[@id='FirstName-error']";
	public static final String LASTNAME_EMPTY_MESSAGE = "//span[@id='LastName-error']";
	public static final String EMAIL_EMPTY_MESSAGE = "//span[@id='Email-error' and text()='Email is required.']";
	public static final String PASSWORD_MESSAGE = "//span[@class='field-validation-error' and @data-valmsg-for='Password']";
	public static final String CONFIRMPASSWORD_MESSAGE = "//span[@class='field-validation-error' and @data-valmsg-for='ConfirmPassword']";
	public static final String ERROR_MESSAGE_ELEMENT(String fieldname) {
		return "//span[@id='"+fieldname+"-error']";
	}
	public static final String REGISTER_FROM = "//div[@class='page registration-page']";
	//span[@class='field-validation-error' and @data-valmsg-for='Password']
	//
}
