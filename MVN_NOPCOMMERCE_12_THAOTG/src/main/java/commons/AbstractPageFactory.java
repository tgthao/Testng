package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageFactory {
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
	public AbstractPageFactory(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		waitExplicit = new WebDriverWait(driver, longTimeout);
	}
	public void waitToElementVisible(WebElement element) {
		waitExplicit.until(ExpectedConditions.visibilityOf(element));
	}
	public void sendkeyToElement(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	public void clickToElement(WebElement element) {
		element.click();
	}
	public void selectItemInDropdown(WebElement element, String valueItem) {
		select = new Select(element);
		select.selectByVisibleText(valueItem);
		
	}
	public boolean isElementDisplayed(WebElement element) {
		
		return element.isDisplayed();
	}
	public String getTextElement(WebElement element) {
		return element.getText();
	}
}
