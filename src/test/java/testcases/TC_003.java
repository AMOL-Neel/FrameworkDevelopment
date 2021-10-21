package testcases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageobjects.HomePageObjects;
import pages.BasePage;

public class TC_003 extends BasePage {
	
	private static final Logger logger = LogManager.getLogger(TC_003.class);

	@Test
	public void tc_003_check_sign_in_button_on_home_page_without_using_page_object_model() {
		logger.info("Test case Started: without using page object model");
		driver.get(base_url);
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Sign in securely')]"));
		element.click();

		if (driver.findElement(By.xpath("//input[@type='email']")).isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Email text box does not appear for login after clicking on sign in button");
		}
		logger.info("Test Case End");
	}
	
	
	@Test
	public void tc_004_check_sign_in_button_on_home_page_with_using_page_object_model() {
		logger.info("Test case Started: with using page object model");
		driver.get(base_url);
		HomePageObjects homePageObjects = new HomePageObjects(driver);
		homePageObjects.click_sign_in_security_link();
		logger.info("successfully click on login security link");
		homePageObjects.input_text_box_is_appear();
		logger.info("successfully get into login page.");
		logger.info("Test Case End");
	}
	

}
