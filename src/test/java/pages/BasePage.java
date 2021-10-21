package pages;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import webdriverfactory.WebDriverFactory;

public class BasePage {
	protected WebDriver driver;// this should never be static, if made static
								// parallel exec of classes not possible
	protected final static String base_url = "https://amazon.in";

	@Before
	public void set_up() {
		try {
			driver = WebDriverFactory.getWebDriverForBrowser("chrome");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Incorrect Browser Sent. check the Stack Trace");

		}
	}

	@After
	public void clean_up() {
		driver.quit();
	}

}
