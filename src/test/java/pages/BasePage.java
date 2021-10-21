package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import testcases.TC_003;
import webdriverfactory.WebDriverFactory;

public class BasePage {
	
	private static final Logger logger = LogManager.getLogger(BasePage.class);
	protected WebDriver driver;// this should never be static, if made static
								// parallel exec of classes not possible
	protected final static String base_url = "https://amazon.in";
	protected final static String defaultPageTitleText = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

	private String getBrowserName() {
		String browserDefault = "headless"; // Set by default
		String browserSentFromCmd = System.getProperty("browser");
		

		if (browserSentFromCmd == null) {
			return browserDefault;
		} else {
			return browserSentFromCmd;
		}
	}

	@Before
	public void set_up() {
		String browser = getBrowserName();
		try {
			driver = WebDriverFactory.getWebDriverForBrowser("chrome");//Instead of "chrome" here We need to pass getBrowserName(); reference.
			                                                           // if we want to execute our script by using maven command.
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Incorrect Browser Sent. check the Stack Trace");

		}
	}
	
	/*
	 * maven execution command mvn clean install -Dbrowser=safari
	 * browserSentFromCmd = safari
	 */

	@After
	public void clean_up() {
		driver.quit();
	}

}
