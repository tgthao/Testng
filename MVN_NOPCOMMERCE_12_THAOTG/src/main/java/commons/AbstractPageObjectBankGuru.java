package commons;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import nopComerce.pageObjects.FooterMyAccountPO;
import nopComerce.pageObjects.HeaderMyAccountPO;
import nopComerce.pageObjects.HomePO;
import nopComerce.pageObjects.LoginPO;
import nopComerce.pageObjects.PageGeneratorManager;
import nopComerce.pageObjects.RegisterPO;
import nopComerce.pageObjects.SearchPO;
import nopComerce.pageObjects.ShippingAndReturnPO;
import nopComerce.pageObjects.SitemapPO;
import nopComerce.pageUIs.AbstractPageNopCommerceUI;

public class AbstractPageObjectBankGuru {
	 WebDriver driver;
	WebElement element;
	By by;
	Select select;
	JavascriptExecutor jsExecutor;
	WebDriverWait waitExplicit;
	List<WebElement> elements;
	Set<String> allWindows;
	Actions action;
	long shortTimeout = 5;
	long longTimeout = 30;

	public AbstractPageObjectBankGuru(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		jsExecutor = (JavascriptExecutor) driver;
		waitExplicit = new WebDriverWait(driver, longTimeout);

	}

	/* WEB BROWSER */

	public void openURL(String url) {
		driver.get(url);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}

	public void backToPage() {
		driver.navigate().back();
	}

	public void forwardToPage() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}

	public void sendKeyToAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	/* WEB ELEMENTS */

	public void clickToElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	// n param
	public void clickToElement(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKeyToElement(String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}
	public void sendKeyToElement(String locator, String valueToSendkey,String ...values) {
		locator = castRestParameter(locator, values);
		element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(valueToSendkey);
	}

	public void selectItemInDropdown(String locator, String valueItem) {
		element = find(locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}
	public void selectItemInDropdown(String locator, String valueItem,String ...values) {
		locator = castRestParameter(locator, values);
		element = find(locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
		driver.switchTo().frame(element);
	}

	public String getFirstItemInDropdown(String locator) {
		select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInCustomDropdown(String parentLocator, String allItemsLocator, String expectedItem) {
		jsExecutor = (JavascriptExecutor) driver;
		waitExplicit = new WebDriverWait(driver, longTimeout);

		WebElement element = driver.findElement(By.xpath(parentLocator));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
		jsExecutor.executeScript("arguments[0].click();", element);

		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsLocator)));

		elements = driver.findElements(By.xpath(allItemsLocator));
		for (WebElement item : elements) {
			if (item.getText().equals(expectedItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getAttributeValue(String locator, String attributeName) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextElement(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countNumberOfElement(String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public boolean isElementDisplayed(String locator) {
		overideGlobalTimeout(shortTimeout);
		try {
			element = find(locator);
			overideGlobalTimeout(longTimeout);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			overideGlobalTimeout(longTimeout);
			return false;
		}
	}

	public void overideGlobalTimeout(long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isElementDisplayed(String locator, String... values) {
		locator = castRestParameter(locator, values);
		overideGlobalTimeout(shortTimeout);
		try {
			element = find(locator);
			overideGlobalTimeout(longTimeout);
			return element.isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			overideGlobalTimeout(longTimeout);
			return false;
		}

	}

	public boolean isElementSelected(String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isElementEnabled(String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void checkToCheckBox(String locator) {
		if (!isElementSelected(locator)) {
			clickToElement(locator);
		}
	}

	public void unCheckToCheckBox(String locator) {
		if (isElementSelected(locator)) {
			clickToElement(locator);
		}
	}

	public WebElement find(String locator) {
		return driver.findElement(By.xpath(locator));
	}

	public String castRestParameter(String locator, String... value) {
		locator = String.format(locator, (Object[]) value);
		return locator;
	}

	public void switchToWindowsByTitle(String title) {
		allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWindow = driver.getTitle();
			if (currentWindow.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(String parentWindow) {
		allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentWindow)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);

		if (driver.getWindowHandles().size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void switchToFrameOrIframe(String locator) {
		element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}

	public void switchToParentPage() {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(String locator) {
		element = driver.findElement(By.xpath(locator));
		action.doubleClick(element).perform();
	}

	public void sendKeyBoardToElement(String locator, Keys key) {
		element = driver.findElement(By.xpath(locator));
		action.sendKeys(element, key).perform();
	}

	public boolean checkImageLoaded(String locator) {
		element = driver.findElement(By.xpath(locator));
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth>0",
				element);
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTextInInnerText(String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void waitToElementVisible(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		by = By.xpath(locator);
		// waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
		System.out.println(by);
	}

	public By byXpath(String locator) {
		return By.xpath(locator);
	}

	public void waitToElementInvisible(String locator) {
		by = byXpath(locator);
		overideGlobalTimeout(shortTimeout);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(by));
		overideGlobalTimeout(longTimeout);
	}

	public void waitToElementClickable(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		by = By.xpath(locator);
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(by));

	}

	public boolean isElementEquals01(String locator, String expectedResult) {
		element = driver.findElement(By.xpath(locator));
		String actualText = element.getText();
		return actualText.equals(expectedResult);

	}

	public boolean isElementEquals(String locator, String expectedResult) {
		element = driver.findElement(By.xpath(locator));
		String actualText = element.getText();
		Assert.assertEquals(actualText, expectedResult);
		return true;

	}

	public void sleepInSecond(long numberInSecond) {
		try {
			Thread.sleep(numberInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt();
	}

	// 28 METHOD OPEN 28 PAGES
	public HeaderMyAccountPO openHeaderMyAccountPage() {
		waitToElementVisible(AbstractPageNopCommerceUI.HEADER_MY_ACCOUNT_LINK);
		clickToElement(AbstractPageNopCommerceUI.HEADER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getHeaderMyAccountPage(driver);
	}

	public HomePO openHomePage() {
		waitToElementVisible(AbstractPageNopCommerceUI.HEADER_MY_ACCOUNT_LINK);
		clickToElement(AbstractPageNopCommerceUI.HEADER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public SitemapPO openSiteMapPage() {
		waitToElementVisible(AbstractPageNopCommerceUI.FOOTER_SITE_MAP_LINK);
		clickToElement(AbstractPageNopCommerceUI.FOOTER_SITE_MAP_LINK);
		return PageGeneratorManager.getSitemapPage(driver);
	}

	public SearchPO openSearchPage() {
		waitToElementVisible(AbstractPageNopCommerceUI.FOOTER_SEARCH_LINK);
		clickToElement(AbstractPageNopCommerceUI.FOOTER_SEARCH_LINK);
		return PageGeneratorManager.getSearchPage(driver);
	}

	public FooterMyAccountPO openFooterMyAccountPage() {
		waitToElementVisible(AbstractPageNopCommerceUI.HEADER_MY_ACCOUNT_LINK);
		clickToElement(AbstractPageNopCommerceUI.HEADER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getFooterMyAccountPage(driver);
	}

	public ShippingAndReturnPO openShippingAndReturnPage() {
		waitToElementVisible(AbstractPageNopCommerceUI.HEADER_MY_ACCOUNT_LINK);
		clickToElement(AbstractPageNopCommerceUI.HEADER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getShippingAndReturnPage(driver);
	}

	public LoginPO openLoginPage() {
		// TODO Auto-generated method stub
		waitToElementVisible(AbstractPageNopCommerceUI.HEADER_LOGIN_LINK);
		clickToElement(AbstractPageNopCommerceUI.HEADER_LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public RegisterPO openRegisterPage() {
		// TODO Auto-generated method stub
		waitToElementVisible(AbstractPageNopCommerceUI.HEADER_REGISTER_LINK);
		clickToElement(AbstractPageNopCommerceUI.HEADER_REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);

	}
	// 1 method open 28 pages (n pages)

	// 20 - 25 pages
	public void openMultiPage(String pageName) {
		waitToElementVisible(AbstractPageNopCommerceUI.DYNAMIC_FOOTERLINK, pageName);
		clickToElement(AbstractPageNopCommerceUI.DYNAMIC_FOOTERLINK, pageName);

	}

	// Dynamic Element Component
	public void inputtoDynamicTextbox(String textboxID,String value) {
		waitToElementVisible(AbstractPageNopCommerceUI.DYNAMIC_TEXTBOX, textboxID);
		sendKeyToElement(AbstractPageNopCommerceUI.DYNAMIC_TEXTBOX, value, textboxID);
	}
	public void inputtoDynamicTextArea(String textAreaID,String value) {
		waitToElementVisible(AbstractPageNopCommerceUI.DYNAMIC_TEXTBOX, textAreaID);
		sendKeyToElement(AbstractPageNopCommerceUI.DYNAMIC_TEXTBOX, value, textAreaID);
	}

	public void clickToDynamicButton(String buttonValue) {
		waitToElementVisible(AbstractPageNopCommerceUI.DYNAMIC_BUTTON, buttonValue);
		clickToElement(AbstractPageNopCommerceUI.DYNAMIC_BUTTON, buttonValue);
	}

	public void clickToDynamicRadioButton(String radioButtonID) {
		waitToElementVisible(AbstractPageNopCommerceUI.DYNAMIC_RADIO_BUTTON, radioButtonID);
		clickToElement(AbstractPageNopCommerceUI.DYNAMIC_RADIO_BUTTON, radioButtonID);
	}

	public void clickToDynamicCheckbox(String checkboxID) {
		waitToElementVisible(AbstractPageNopCommerceUI.DYNAMIC_CHECKBOX, checkboxID);
		clickToElement(AbstractPageNopCommerceUI.DYNAMIC_CHECKBOX, checkboxID);
	}

	public void selectToDynamiDropdown(String dropdownName, String valueItem) {
		waitToElementVisible(AbstractPageNopCommerceUI.DYNAMIC_DROPDOWN_LIST, dropdownName);
		selectItemInDropdown(AbstractPageNopCommerceUI.DYNAMIC_DROPDOWN_LIST,valueItem, dropdownName);
	}
	public String getDynamicRequireFieldErrorMessage(String fieldID) {
		waitToElementVisible(AbstractPageNopCommerceUI.DYNAMIC_REQUIRED_FIELD_ERROR_MESSAGE, fieldID);
		return getTextElement(AbstractPageNopCommerceUI.DYNAMIC_REQUIRED_FIELD_ERROR_MESSAGE, fieldID);
	}

//	public HomePageObjectGeneral openHeaderMyAccountPage() {
//		waitToElementVisible(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
//		clickToElement(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
//		return PageGeneratorManager.getHeaderMyAccountPage(driver);
//	}
//	public HomePageObjectGeneral openHeaderMyAccountPage() {
//		waitToElementVisible(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
//		clickToElement(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
//		return PageGeneratorManager.getHeaderMyAccountPage(driver);
//	}
}