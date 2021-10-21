package testcases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TC_001 {
	
	WebDriver driver;
	String base_url = "https://amazon.in";
	int  implicit_wait_timeout_in_sec = 20;
	
	
	@Before
	public void set_up(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
	}
	
	@Test
	public void TC_001_check_website_is_working(){
		driver.get(base_url);
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driver.getTitle();
		System.out.println("the actual title is ::"+actual);
		Assert.assertEquals("Page Title Validation",expected,actual);
	}

	@After
	public void close_up(){
		driver.close();
	}
}
