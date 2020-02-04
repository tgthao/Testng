package bankGuru.pageObjects;


import org.openqa.selenium.WebDriver;



public class BankGuruPageGeneratorManager {
	WebDriver driver;
	public static HomePagePO getHomePage(WebDriver driver) {
		return new HomePagePO(driver);
	}
	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}
	public static RegisterPO getRegisterPO(WebDriver driver) {
		return new RegisterPO(driver);
	}
	public static NewCustomerPO getNewtCustomerPO(WebDriver driver) {
		return new NewCustomerPO(driver);
	}
	public static EditCustomerPO getEditCustomerPO(WebDriver driver) {
		return new EditCustomerPO(driver);
	}
	public static DeleteCustomerPO getDeleteCustomerPO(WebDriver driver) {
		return new DeleteCustomerPO(driver);
	}
	public static NewAccountPO getNewAccountPO(WebDriver driver) {
		return new NewAccountPO(driver);
	}
	public static EditAccountPO getEditAccountPO(WebDriver driver) {
		return new EditAccountPO(driver);
	}
	public static DeleteAccountPO getDeleteAccountPO(WebDriver driver) {
		return new DeleteAccountPO(driver);
	}
	public static DepositPO getDepositPO(WebDriver driver) {
		return new DepositPO(driver);
	}
	public static WithdrawnPO getWithDrawnPO(WebDriver driver) {
		return new WithdrawnPO(driver);
	}
	public static FunTransferPO getFunTransferPO(WebDriver driver) {
		return new FunTransferPO(driver);
	}
	public static BalanceEnquiryPO getBalanceEnquiryPO(WebDriver driver) {
		return new BalanceEnquiryPO(driver);
	}
}
