package commons;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractPage {
	WebElement element;
	List<WebElement> elements;
	Select select;
	JavascriptExecutor jsExecutor;
	WebDriverWait waitExplicit;
	Actions action;		
	By by;
	
	public void openUrl(WebDriver driver,String urlValue) {
		driver.get(urlValue);
	}
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	public String getPageCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	public void waitAlertPresence(WebDriver driver) {
		waitExplicit = new WebDriverWait(driver, 20);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	public void sendKeyToAlert(WebDriver driver,String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	public void clickToElement(WebDriver driver,String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}
	public void sendKeyToElement(WebDriver driver,String locator,String value) {
		element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}
	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}
	public String getValueItemInDropdown(WebDriver driver, String locator, String valueItem) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	public void selectItemInDropdownJs(WebDriver driver,String parentLocation, String allitemsLocators, String expectedItem) {
		//Click vaof dropdown để hiển thị ra các item
		element = driver.findElement(By.xpath(parentLocation));
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].click()", element);
		sleepInSecond(1);
		waitExplicit = new WebDriverWait(driver, 20);
		//Chờ cho tất cả item được load lên thành công
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allitemsLocators)));
		elements = driver.findElements(By.xpath(allitemsLocators));
		for(WebElement item : elements) {
			if(item.getText().equals(expectedItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
		
	}
	public String getAttributeValue(WebDriver driver,String locator, String attributeName ) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}
	public String getTextElement(WebDriver driver,String locator ) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	public int countElementNumber(WebDriver driver,String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}
	public void checkTheCheckbox(WebDriver driver,String locator) {
		element = driver.findElement(By.xpath(locator));
		if(element.isSelected()== false) {
			element.click();
		}
	}
	public void uncheckTheCheckbox(WebDriver driver,String locator) {
		element = driver.findElement(By.xpath(locator));
		if(element.isSelected()== true) {
			element.click();
		}
	}
	public boolean isElementDisplayed(WebDriver driver,String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	public boolean isElementControlSelected(WebDriver driver,String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}
	public boolean isControlEnabled(WebDriver driver,String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	public void switchToWindowByTitlte(WebDriver driver,String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String runWindow: allWindows) {
			driver.switchTo().window(runWindow);
			String currentWin = driver.getTitle();
			if(currentWin.equals(title)) {
				break;
			}
		}
	}
	public boolean closeAllWindowsWithoutParent(WebDriver driver,String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String runWindow: allWindows) {
			if(!runWindow.equals(parentWindow)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if(driver.getWindowHandles().size()==1) {
			return true;
		}
		else
			return false;
	}
	public void swithcToFrameOrIframe(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}
	public void switchToParentPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void hoverToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	public void doubleClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.moveToElement(element).doubleClick();
		
	}
	public void sendKyeboardToElement(WebDriver driver,String locator, Keys key) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element,key).perform();
	}
	public boolean checkAnyImageLoaded(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
		if(status) {
			return true;
		} else {
			return false;
		}

	}
	public boolean verifyTextInInnerText(WebDriver driver,String textExpected) {
	
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return (boolean) textActual.equals(textExpected);
	}
	public void waitToElementVisible(WebDriver driver, String locator) {
		by = By.xpath(locator);
		waitExplicit = new WebDriverWait(driver, 20);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	public void waitToElementPresence(WebDriver driver, String locator) {
		by = By.xpath(locator);
		waitExplicit = new WebDriverWait(driver, 20);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	public void waitToElementInvisible(WebDriver driver, String locator) {
		by = By.xpath(locator);
		waitExplicit = new WebDriverWait(driver, 20);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	public void waitToElementClickable(WebDriver driver, String locator) {
		by = By.xpath(locator);
		waitExplicit = new WebDriverWait(driver, 20);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
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
		return random.nextInt(99999);
	}
}
