package webdriverfactory;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	private static WebDriver driver = null;
	private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

	public static WebDriver getWebDriverForBrowser(String browser) throws Exception {
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "headless":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");
			driver = new ChromeDriver(options);
			logger.info("Headless Chrome Browser invoked");
			break;
		default:
			throw new Exception("No such browser is implemented.Browser name sent: " + browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Driver maximized and implicit time out set to 20 seconds");
		return driver;
	}

	public static void navigateToTheUrl(String url) {
		driver.get(url);
		logger.info("Browser navigated to the url: " + url);
	}

}
