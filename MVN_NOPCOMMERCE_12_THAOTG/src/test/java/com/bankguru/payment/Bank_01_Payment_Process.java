
package com.bankguru.payment;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankGuru.pageObjects.HomePagePO;
import bankGuru.pageObjects.LoginPO;
import bankGuru.pageObjects.NewAccountPO;
import bankGuru.pageObjects.NewCustomerPO;
import bankGuru.pageObjects.BankGuruPageGeneratorManager;
import bankGuru.pageObjects.DeleteAccountPO;
import bankGuru.pageObjects.DepositPO;
import bankGuru.pageObjects.EditAccountPO;
import bankGuru.pageObjects.EditCustomerPO;
import bankGuru.pageObjects.FunTransferPO;
import bankGuru.pageObjects.RegisterPO;
import bankGuru.pageObjects.WithdrawnPO;
import commons.AbstractPageObject;
import commons.AbstractTest;

public class Bank_01_Payment_Process extends AbstractTest {

	private WebDriver driver;
	private LoginPO loginPage;
	private RegisterPO registerPage;
	private HomePagePO homePagePO;
	private NewCustomerPO newCustomerPage;
	private EditCustomerPO editCustomerPage;
	private NewAccountPO newAccountPage;
	private EditAccountPO editAccountPage;
	private DepositPO depositPage;
	private WithdrawnPO withDrawnPage;
	private FunTransferPO funTranserPage;
	private DeleteAccountPO deleteAccountPage;
	private AbstractPageObject abstractPage;

	private String Email, userID, passWord, loginPageUrl, customerID, accountTypeSaving, accountTypeCurrent,firstAccountID,secondAccountID;
	private String name, gender, dateOfBirth, address, city, state, pin, phone, accountID;
	private String editName, editDateOfBirth, editAddress, editCity, editState, editPin, editPhone, editEmail;

	// private WebDriver driver; mngr239195, ugAgyjY
	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeClass(String browserName, String url) {
		driver = OpenMultiBrowsers02(browserName, url);
		Email = "tgt" + randomNumber() + "@gmail.com";
		loginPage = BankGuruPageGeneratorManager.getLoginPage(driver);
		// mngr239372
//		/pynEnyq
		// New Customer
		name = "Automation FC";
		gender = "male";
		dateOfBirth = "2019-12-25";
		address = "259 PO Box";
		city = "Los Angeles";
		state = "Homestay";
		pin = "365265";
		phone = "0905303269";
		// Edit Customer
		editAddress = "324 PE Pax";
		editCity = "Hawaii";
		editState = "Brew";
		editPin = "652698";
		editPhone = "0965326698";
		editEmail = "editautofc" + randomNumber() + "@gmail.com";

		accountTypeCurrent = "Current";
		accountTypeSaving = "Savings";
		abstractPage = new AbstractPageObject(driver);

	}

	@Test
	public void Payment_01_RegisterAndLogin() {
		log.info("Register And Login - Step 01: Get Login Page URL");
		loginPageUrl = loginPage.getLoginPageUrl();

		log.info("Register And Login - Step 02: Click to here link");
		registerPage = loginPage.clickToHereLink();

		log.info("Register And Login - Step 03: Input to EmailID textbox");
		registerPage.inputToEmailIDTextbox(Email);

		log.info("Register And Login - Step 04: Click to Submit button");
		registerPage.clickDynamicButton("Submit");

		log.info("Register And Login - Step 05: Get User ID Value URL");
		userID = registerPage.getUserIDValue();
		log.info("User ID: " + userID);

		log.info("Register And Login - Step 06: Get Password Value URL");
		passWord = registerPage.getPasswordValue();
		log.info("Password: " + passWord);

		log.info("Register And Login - Step 07: Get Login Page URL");
		loginPage = registerPage.openLoginPage(loginPageUrl);

		log.info("Register And Login - Step 08: Input Email Textbox");
		loginPage.inputToUserIDTextbox(userID);

		log.info("Register And Login - Step 09: Input Password Textbox");
		loginPage.inputToPasswordTextbox(passWord);

		log.info("Register And Login - Step 10: Click To Submit Button");
		homePagePO = loginPage.clickToSubmitButton();

		log.info("Register And Login - Step 11: Verify Message Displayed ");
		verifyTrue(homePagePO.isWelcomeMessageDisplayed());
	}

	@Test
	public void Payment_02_NewCustomer() {
		log.info("Payment_02_NewCustomer - Step 01: Open Guru 99 site");
		newCustomerPage = (NewCustomerPO) homePagePO.openMultipleBankGuruPage("New Customer");
		log.info(newCustomerPage instanceof NewCustomerPO);

		log.info("Payment_02_NewCustomer - Step 02: Displayed Add New Customer");
		verifyTrue(newCustomerPage.isDynamicHeaderOrMessageDisplayed("Add New Customer"));

		log.info("Payment_02_NewCustomer - Step 03: Input to EmailID textbox");

		newCustomerPage.inputToDynamicTextboxOrTextArea("name", name);
		newCustomerPage.inputToDynamicTextboxOrTextArea("dob", dateOfBirth);
		newCustomerPage.inputToDynamicTextboxOrTextArea("addr", address);
		newCustomerPage.inputToDynamicTextboxOrTextArea("city", city);
		newCustomerPage.inputToDynamicTextboxOrTextArea("state", state);
		newCustomerPage.inputToDynamicTextboxOrTextArea("pinno", pin);
		newCustomerPage.inputToDynamicTextboxOrTextArea("telephoneno", phone);
		newCustomerPage.inputToDynamicTextboxOrTextArea("emailid", Email);
		newCustomerPage.inputToDynamicTextboxOrTextArea("password", "GiangThao$$$123Thao");
		newCustomerPage.clickDynamicButton("Submit");
		log.info("Payment_02_NewCustomer - Step 03: Verify True Message Create Customer Successfull");

		log.info("Payment_02_NewCustomer - Step 03: Verify True Message Create Customer Successfull");
		newCustomerPage.isDynamicHeaderOrMessageDisplayed("Customer Registered Successfully!!!");
		verifyEquals(newCustomerPage.getDynamicTextIntoTable("Customer Name"), name);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable("Gender"), gender);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable("Birthdate"), dateOfBirth);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable("Address"), address);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable("City"), city);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable("State"), state);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable("Pin"), pin);
		verifyEquals(newCustomerPage.getDynamicTextIntoTable("Mobile No."), phone);
		customerID = newCustomerPage.getDynamicTextIntoTable("Customer ID");
		log.info("Customer ID: " + customerID);

	}

	@Test
	public void Payment_03_EditCustomer() {
		log.info("Payment_03_EditCustomer - Step 01: Click Edit Customer");
		editCustomerPage = (EditCustomerPO) newCustomerPage.openMultipleBankGuruPage("Edit Customer");
		log.info(editCustomerPage instanceof EditCustomerPO);
		editCustomerPage.inputToDynamicTextboxOrTextArea("cusid", customerID);
		editCustomerPage.clickDynamicButton("Submit");
		verifyTrue(editCustomerPage.isDynamicHeaderOrMessageDisplayed("Edit Customer"));
		editCustomerPage.inputToDynamicTextboxOrTextArea("addr", editAddress);
		editCustomerPage.inputToDynamicTextboxOrTextArea("city", editCity);
		editCustomerPage.inputToDynamicTextboxOrTextArea("state", editState);
		editCustomerPage.inputToDynamicTextboxOrTextArea("pinno", editPin);
		editCustomerPage.inputToDynamicTextboxOrTextArea("telephoneno", editPhone);
		editCustomerPage.inputToDynamicTextboxOrTextArea("emailid", editEmail);
		editCustomerPage.clickDynamicButton("Submit");

		verifyTrue(editCustomerPage.isDynamicHeaderOrMessageDisplayed("Customer details updated Successfully!!!"));
		verifyEquals(editCustomerPage.getDynamicTextIntoTable("Address"), editAddress);
		verifyEquals(editCustomerPage.getDynamicTextIntoTable("City"), editCity);
		verifyEquals(editCustomerPage.getDynamicTextIntoTable("State"), editState);
		verifyEquals(editCustomerPage.getDynamicTextIntoTable("Pin"), editPin);
		verifyEquals(editCustomerPage.getDynamicTextIntoTable("Mobile No."), editPhone);
		verifyEquals(editCustomerPage.getDynamicTextIntoTable("Email"), editEmail);
	}

	@Test
	public void Payment_04_NewAccount() {
		//First Account
		log.info("Payment_04_NewAccount - Step 01: Click New Account");
		newAccountPage = (NewAccountPO) editCustomerPage.openMultipleBankGuruPage("New Account");
		log.info(newAccountPage instanceof NewAccountPO);
		log.info("Payment_04_NewAccount - Step 02: Verify Displayed Add New Account Form");
		newAccountPage.isDynamicHeaderOrMessageDisplayed("Add new account form");
		newAccountPage.inputToDynamicTextboxOrTextArea("cusid", customerID);
		newAccountPage.selectDynamiDropdown("selaccount", accountTypeSaving);
		newAccountPage.inputToDynamicTextboxOrTextArea("inideposit", "5000");
		newAccountPage.clickDynamicButton("submit");

		verifyTrue(newAccountPage.isDynamicHeaderOrMessageDisplayed("Account Generated Successfully!!!"));
		verifyEquals(newAccountPage.getDynamicTextIntoTable("Customer ID"), customerID);
		verifyEquals(newAccountPage.getDynamicTextIntoTable("Customer Name"),name );
		verifyEquals(newAccountPage.getDynamicTextIntoTable("Email"), editEmail);
		verifyEquals(newAccountPage.getDynamicTextIntoTable("Account Type"), accountTypeSaving);
		verifyEquals(newAccountPage.getDynamicTextIntoTable("Date of Opening"), getToday());
		verifyEquals(newAccountPage.getDynamicTextIntoTable("Current Amount"), "5000");

		firstAccountID = newAccountPage.getDynamicTextIntoTable("Account ID");
		//Second Account
		log.info("Payment_04_NewAccount - Step 01: Click New Account");
		newAccountPage = (NewAccountPO) editCustomerPage.openMultipleBankGuruPage("New Account");
		log.info(newAccountPage instanceof NewAccountPO);
		log.info("Payment_04_NewAccount - Step 02: Verify Displayed Add New Account Form");
		newAccountPage.isDynamicHeaderOrMessageDisplayed("Add new account form");
		newAccountPage.inputToDynamicTextboxOrTextArea("cusid", customerID);
		newAccountPage.selectDynamiDropdown("selaccount", accountTypeSaving);
		newAccountPage.inputToDynamicTextboxOrTextArea("inideposit", "5000");
		newAccountPage.clickDynamicButton("submit");
		secondAccountID = newAccountPage.getDynamicTextIntoTable("Account ID");
	}

	@Test
	public void Payment_05_EditAccount() {
		log.info("Payment_05_EditAccount - Step 01: Click Edit Account");
		editAccountPage = (EditAccountPO) newAccountPage.openMultipleBankGuruPage("Edit Account");
		log.info(editAccountPage instanceof EditAccountPO);
		log.info("Payment_04_NewAccount - Step 02: Verify Displayed Edit Account Form");
		editAccountPage.isDynamicHeaderOrMessageDisplayed("Edit Account Form");
		editAccountPage.inputToDynamicTextboxOrTextArea("accountno", firstAccountID);
		editAccountPage.clickDynamicButton("Submit");
		editAccountPage.selectDynamiDropdown("a_type", accountTypeCurrent);
		editAccountPage.clickDynamicButton("Submit");

		log.info("Payment_04_NewAccount - Step 02: Verify Displayed Account details updated Successfully!!!");
		editAccountPage.isDynamicHeaderOrMessageDisplayed("Account details updated Successfully!!!");
		verifyEquals(editAccountPage.getDynamicTextIntoTable("Account ID"), firstAccountID);
		verifyEquals(editAccountPage.getDynamicTextIntoTable("Account Type"), accountTypeCurrent);
		verifyEquals(editAccountPage.getDynamicTextIntoTable("Date of Opening"), getToday());

	}

	@Test
	public void Payment_06_DepositToAccount() {
		// mngr239999
		// EbejuzU
		// Customer ID 42447
		// account ID 74668
		log.info("Payment_06_DepositToAccount - Step 01: Click Deposit Page");
		depositPage = (DepositPO) editAccountPage.openMultipleBankGuruPage("Deposit");
		log.info(depositPage instanceof DepositPO);
		log.info("Payment_04_NewAccount - Step 02: Verify Displayed Amount Deposit Form");
		depositPage.isDynamicHeaderOrMessageDisplayed("Amount Deposit Form");

		depositPage.inputToDynamicTextboxOrTextArea("accountno", firstAccountID);
		depositPage.inputToDynamicTextboxOrTextArea("ammount", "8000");
		depositPage.inputToDynamicTextboxOrTextArea("desc", "Giang Thao");
		depositPage.clickDynamicButton("Submit");

		log.info("Payment_06_DepositToAccount - Step 03: Verify Displayed Deposit successflull");
		depositPage.isDynamicHeaderOrMessageDisplayed("Transaction details of Deposit for Account " + firstAccountID);

		log.info("Payment_06_DepositToAccount - Step 04: Verify Data");
		verifyEquals(depositPage.getDynamicTextIntoTable("Account No"), firstAccountID);
		verifyEquals(depositPage.getDynamicTextIntoTable("Amount Credited"), "8000");
		verifyEquals(depositPage.getDynamicTextIntoTable("Type of Transaction"), "Deposit");
		verifyEquals(depositPage.getDynamicTextIntoTable("Description"), "Giang Thao");
		verifyEquals(depositPage.getDynamicTextIntoTable("Current Balance"), "13000");

	}

	@Test
	public void Payment_07_WithdrawalFromAccount() {
		// mngr239999
		// EbejuzU
		// Customer ID 42447
		// account ID 74668 74669
		log.info("Payment_07_WithdrawalFromAccount - Step 01: Click Withdrawal Page");
		withDrawnPage = (WithdrawnPO) depositPage.openMultipleBankGuruPage("Withdrawal");
		log.info(withDrawnPage instanceof WithdrawnPO);
		log.info("Payment_07_WithdrawalFromAccount - Step 02: Verify Displayed Amount Withdrawal Form");
		withDrawnPage.isDynamicHeaderOrMessageDisplayed("Amount Withdrawal Form");

		withDrawnPage.inputToDynamicTextboxOrTextArea("accountno", firstAccountID);
		withDrawnPage.inputToDynamicTextboxOrTextArea("ammount", "2000");
		withDrawnPage.inputToDynamicTextboxOrTextArea("desc", "Giang Thao");
		withDrawnPage.clickDynamicButton("Submit");

		log.info("Payment_06_DepositToAccount - Step 03: Verify Displayed Transaction details of Withdrawal for Account");
		withDrawnPage.isDynamicHeaderOrMessageDisplayed("Transaction details of Withdrawal for Account " + firstAccountID);

		log.info("Payment_06_DepositToAccount - Step 04: Verify Data");
		verifyEquals(withDrawnPage.getDynamicTextIntoTable("Account No"), firstAccountID);
		verifyEquals(withDrawnPage.getDynamicTextIntoTable("Amount Debited"), "2000");
		verifyEquals(withDrawnPage.getDynamicTextIntoTable("Type of Transaction"), "Withdrawal");
		verifyEquals(withDrawnPage.getDynamicTextIntoTable("Description"), "Giang Thao");
		verifyEquals(withDrawnPage.getDynamicTextIntoTable("Current Balance"), "11000");
	}

	
	public void Payment_08_TransferToOtherAccount() {
		log.info("Payment_08_TransferToOtherAccount - Step 01: Click Fun transfer Page");
		funTranserPage = (FunTransferPO) withDrawnPage.openMultipleBankGuruPage("Fund Transfer");
		log.info(funTranserPage instanceof FunTransferPO);
		log.info("Payment_08_TransferToOtherAccount - Step 02: Verify Displayed Amount Withdrawal Form");
		//funTranserPage.isDynamicHeaderOrMessageDisplayed("Fund transfer");

		funTranserPage.inputToDynamicTextboxOrTextArea("accountno", firstAccountID);
		funTranserPage.inputToDynamicTextboxOrTextArea("ammount", "2000");
		funTranserPage.inputToDynamicTextboxOrTextArea("desc", "Giang Thao");
		funTranserPage.clickDynamicButton("Submit");

		log.info("Payment_06_DepositToAccount - Step 03: Verify Displayed Transaction details of Withdrawal for Account");
		funTranserPage.isDynamicHeaderOrMessageDisplayed("Transaction details of Withdrawal for Account " + firstAccountID);

		log.info("Payment_06_DepositToAccount - Step 04: Verify Data");
		verifyEquals(funTranserPage.getDynamicTextIntoTable("Account No"), firstAccountID);
		verifyEquals(funTranserPage.getDynamicTextIntoTable("Amount Debited"), "2000");
		verifyEquals(funTranserPage.getDynamicTextIntoTable("Type of Transaction"), "Withdrawal");
		verifyEquals(funTranserPage.getDynamicTextIntoTable("Description"), "Giang Thao");
		verifyEquals(funTranserPage.getDynamicTextIntoTable("Current Balance"), "11000");
	}

	@Test
	public void Payment_09_DeleteAllAccount() {
		log.info("Payment_09_DeleteAllAccount - Step 01: Delete Account Form");
		deleteAccountPage = (DeleteAccountPO) withDrawnPage.openMultipleBankGuruPage("Delete Account");
		log.info(deleteAccountPage instanceof DeleteAccountPO);
		log.info("Payment_08_TransferToOtherAccount - Step 02: Verify Displayed Delete Account Form");
		deleteAccountPage.isDynamicHeaderOrMessageDisplayed("Delete Account Form");
		
		deleteAccountPage.inputToDynamicTextboxOrTextArea("accountno", firstAccountID);
		deleteAccountPage.clickDynamicButton("Submit");
		

		deleteAccountPage.acceptAlert();
		

		verifyEquals(deleteAccountPage.getTextAlert(), "Account Deleted Sucessfully");
		deleteAccountPage.acceptAlert();
		
		log.info("Payment_09_DeleteAllAccount - Step 03: Delete Account Form");
		deleteAccountPage.openMultipleBankGuruPage("Delete Account");
		log.info(deleteAccountPage instanceof DeleteAccountPO);
		log.info("Payment_09_DeleteAllAccount - Step 04: Verify Displayed Delete Account Form");
		deleteAccountPage.isDynamicHeaderOrMessageDisplayed("Delete Account Form");
		
		deleteAccountPage.inputToDynamicTextboxOrTextArea("accountno", firstAccountID);
		
		deleteAccountPage.clickDynamicButton("Submit");
		deleteAccountPage.acceptAlert();
		
		verifyEquals(deleteAccountPage.getTextAlert(), "Account does not exist");
		deleteAccountPage.acceptAlert();
		
	}

	@Test
	public void Payment_10_CheckCurrentAmount() {
		log.info("Payment_10_CheckCurrentAmount - Step 01: Delete Account Form");
		deleteAccountPage = (DeleteAccountPO) withDrawnPage.openMultipleBankGuruPage("Delete Account");
		log.info(deleteAccountPage instanceof DeleteAccountPO);
		log.info("Payment_08_TransferToOtherAccount - Step 02: Verify Displayed Delete Account Form");
		deleteAccountPage.isDynamicHeaderOrMessageDisplayed("Delete Account Form");
		
		deleteAccountPage.inputToDynamicTextboxOrTextArea("accountno", firstAccountID);
		deleteAccountPage.clickDynamicButton("Submit");
		
	}

	@Test
	public void Payment_11_DeleteCustomer() {

	}

	@Test
	public void Payment_12_LogoutToSystem() {
		System.out.println("TEST CASE 12");
	}

	@AfterClass
	public void quit() {
		closeBrowserAndDriver(driver);
	}
}
