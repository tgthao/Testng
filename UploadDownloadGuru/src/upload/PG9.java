package upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PG9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl = "http://demo.guru99.com/test/upload/";
		WebDriver driver = new FirefoxDriver();
		driver.get(baseUrl);
		WebElement uploadElement = driver.findElement(By.xpath(".//*[@id='uploadfile_0']"));
		// enter the file path onto the file-selection input field
		uploadElement.sendKeys("C:\\nexhtml.txt");
		//Check the "Iaccept the terms of Services " check box
		driver.findElement(By.id("terms")).click();;
		//Click the Upload File button
		driver.findElement(By.name("send")).click();
	}

}
