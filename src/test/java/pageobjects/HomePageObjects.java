package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class HomePageObjects {
	
	// Section1: Declare a driver object
	WebDriver driver;
	
	// Section2: Define the locators
	private By  link_sign_in_security = By.xpath("//a[contains(text(),'Sign in securely')]");
	
	private By  input_text_box = By.xpath("//input[@type='email']");
	
	
	// Section3: Parameterize the constructor
	public HomePageObjects(WebDriver driver){
		this.driver = driver;	
	}
	
	
	// Section4:  Write Business Methods (Methods to be exposed) agent
	public void click_sign_in_security_link(){
		driver.findElement(link_sign_in_security).click();
	}
	
	public void input_text_box_is_appear(){
		if(driver.findElement(input_text_box).isDisplayed()){
			Assert.assertTrue(true);
		}else{
			Assert.fail("Email text box does not appear for login after clicking on sign in button");
		}
	}

}
