package commons;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private WebDriver driver;
	protected final Log log;
	String rootFolder =System.getProperty("user.dir");
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver OpenMultiBrowsers(String browserName) {
		
		String OS = System.getProperty("os.name").toLowerCase();
		if (OS.contains("mac")) {
			switch (browserName) {
			case "firefox":

				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
				//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, ".\\FileFoxlogs.txt");
				driver = new FirefoxDriver();
				break;
			case "firefox_headless":

				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
				driver = new ChromeDriver();
				break;
			case "chrome_headless":
				System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
				ChromeOptions optionChrome = new ChromeOptions();
				optionChrome.setHeadless(true);
				driver = new ChromeDriver(optionChrome);
				break;
			default:
				System.out.println("Please input name browser");
				break;
			}

		} else {
			if (browserName.equalsIgnoreCase("firefox")) {
				
				WebDriverManager.firefoxdriver().setup();
				//System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
				//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "\\src\\main\\resources\\logFiles\\FileFoxlogs.txt");
				FirefoxProfile profile = new FirefoxProfile();
				//File addBlockExt = new File(rootFolder +"\\browserExtension\\adblock.crx");
				//profile.addExtension(addBlockExt);
				FirefoxOptions options = new FirefoxOptions();
				options.addPreference("browser.download.folderList", 2);
				//options.addPreference("browser.download.dir", rootFolder+"\\downloadedFile");
				options.addPreference("browser.download.useDownloadDir", true);
				options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
				options.setProfile(profile);
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("firefox_headless")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
			} else if (browserName.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("chrome_headless")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.setHeadless(true);
				options.addArguments("--headless");
				options.addArguments("window-size=1920x1080");
				driver = new ChromeDriver(options);
			} else if (browserName.equalsIgnoreCase("safari")) {
			//	WebDriverManager.i	
			} else if (browserName.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				}
			else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				}
			
			else {
				System.out.println("Please input name browser");
			}
			System.out.println("Driver at Abstract Test = " + driver.toString());

		}
		log.info("Driver at Abstract Test = "+driver.toString());
		System.out.println("Browser name = " + browserName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		return driver;
	}
	protected WebDriver OpenMultiBrowsers01(String browserName,String version) {
		String OS = System.getProperty("os.name").toLowerCase();
		if (OS.contains("mac")) {
			switch (browserName) {
			case "firefox":

				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
				//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, ".\\FileFoxlogs.txt");
				driver = new FirefoxDriver();
				break;
			case "firefox_headless":

				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
				driver = new ChromeDriver();
				break;
			case "chrome_headless":
				System.setProperty("webdriver.chrome.driver", ".s/resources/chromedriver");
				ChromeOptions optionChrome = new ChromeOptions();
				optionChrome.setHeadless(true);
				driver = new ChromeDriver(optionChrome);
				break;
			default:
				System.out.println("Please input name browser");
				break;
			}

		} else {
			if (browserName.equalsIgnoreCase("firefox")) {
				//System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");
				WebDriverManager.firefoxdriver().version(version).setup();
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
				//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, ".\\FileFoxlogs.txt");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("firefox_headless")) {
				WebDriverManager.firefoxdriver().version(version).setup();
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
			} else if (browserName.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("chrome_headless")) {
				System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setHeadless(true);
				driver = new ChromeDriver(options);
			} else if (browserName.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				}
			else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				}
			else {
				System.out.println("Please input name browser");
			}
			
			System.out.println("Driver at Abstract Test = " + driver.toString());

		}
		log.info("Driver at Abstract Test = "+driver.toString());
		System.out.println("Browser name = " + browserName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
	protected WebDriver OpenMultiBrowsers02(String browserName,String url) {
		String rootFolder = System.getProperty("user.dir");
		String OS = System.getProperty("os.name").toLowerCase();
		if (OS.contains("mac")) {
			switch (browserName) {
			case "firefox":

				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
				//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, ".\\FileFoxlogs.txt");
				FirefoxProfile profile = new FirefoxProfile();
				File addBlockExt = new File( "/Volumes/SPRING/workspace/pom_nopcommerce_12_thaotg/browserExtension/adblock-plus-3.7.xpi");
				File uBlockExt = new File( "/Volumes/SPRING/workspace/pom_nopcommerce_12_thaotg/browserExtension/ublock_origin_1.24.2.xpi");
				profile.addExtension(addBlockExt);
				profile.addExtension(uBlockExt);
				FirefoxOptions options = new FirefoxOptions();
				options.setProfile(profile);
				driver = new FirefoxDriver(options);
				driver.manage().window().maximize();
				
				break;
			case "firefox_headless":

//				FirefoxOptions optionsw1 = new FirefoxOptions();
//				optionsw1.setHeadless(true);
//				driver = new FirefoxDriver(optionsw1);
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
				driver = new ChromeDriver();
				break;
			case "chrome_headless":
				System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
				ChromeOptions optionChrome = new ChromeOptions();
				optionChrome.setHeadless(true);
				driver = new ChromeDriver(optionChrome);
				break;
			default:
				System.out.println("Please input name browser");
				break;
			}

		} else {
			if (browserName.equalsIgnoreCase("firefox")) {
				//System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");
				WebDriverManager.firefoxdriver().setup();
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
				//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, ".\\FileFoxlogs.txt");
				FirefoxProfile profile = new FirefoxProfile();
				File addBlockExt = new File(rootFolder + "\\browserExtension\\adblock-plus-3.7.xpi");
				File uBlockExt = new File(rootFolder + "\\browserExtension\\ublock_origin_1.24.2.xpi");
				profile.addExtension(addBlockExt);
				profile.addExtension(uBlockExt);
				FirefoxOptions options = new FirefoxOptions();
				options.setProfile(profile);
				driver = new FirefoxDriver(options);
				driver.manage().window().maximize();
			} else if (browserName.equalsIgnoreCase("firefox_headless")) {
				System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
			} else if (browserName.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("chrome_headless")) {
				System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setHeadless(true);
				driver = new ChromeDriver(options);
			}else if (browserName.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				}
			else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				}
			else {
				System.out.println("Please input name browser");
			}
			System.out.println("Driver at Abstract Test = " + driver.toString());

		}
		log.info("Driver at Abstract Test = "+driver.toString());
		System.out.println("Browser name = " + browserName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

	protected int randomNumber() {
		Random random = new Random();
		return random.nextInt();
	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info("------Passed-----");
			} else {
				log.info("--Failed");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			// TODO: handle exception
			pass = false;
			// Add error to Report  HTML
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		System.out.println("Status = " + pass);
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info("------Passed-----");
			} else {
				log.info("--Failed--");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			// TODO: handle exception
			pass = false;
			// Add error to Report  HTML
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		System.out.println("Status = " + pass);
		return pass;
	}
	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}
	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		boolean status;
		try {
			if (actual instanceof String && expected instanceof String) {
				actual = actual.toString().trim();
				log.info("Actual= "+actual);
				expected = expected.toString().trim();
				log.info("Expected= "+expected);
				status = (actual.equals(expected));
			} else {
				status = (actual == expected);
			}
			if (status) {
				log.info("-----------------------PASSED-------------------");
			} else {
				log.info("-----------------------FAILED-------------------");
			}
			Assert.assertEquals(actual, expected, "Value is not matching");

		} catch (Throwable e) {
			// TODO: handle exception
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);

	}
	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			// get ra tÃªn cá»§a OS vÃ  convert qua chá»¯ thÆ°á»�ng
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			// Khai bÃ¡o 1 biáº¿n command line Ä‘á»ƒ thá»±c thi
			String cmd = "";
			if (driver != null) {
				driver.quit();
			}

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			}

			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return day + "";
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return month + "";
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		return now.getYear() + "";
	}

	protected String getToday() {
		return getCurrentYear() + "-" + getCurrentMonth() + "-" + getCurrentDay();
	}
	public void printBrowserConsoleLogs(WebDriver driver) {
		LogEntries logs = driver.manage().logs().get("browser");
		List<LogEntry> logList = logs.getAll();
		for(LogEntry logging:logList) {
			System.out.println(logging.getLevel().toString());
		}
	}
}
