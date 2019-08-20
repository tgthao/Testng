package download;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class PG8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String bareUrl = "http://demo.guru99.com/test/yahoo.html";
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get(bareUrl);
		WebElement downloadButton = driver.findElement(By.id("messenger-download"));
		String sourceLocation = downloadButton.getAttribute("href");
		String wget_command ="cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;
		try {
			Process exec = Runtime.getRuntime().exec(wget_command);
			 int exitVal = exec.waitFor();
			 System.out.println("Exit value:" +exitVal);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
}
