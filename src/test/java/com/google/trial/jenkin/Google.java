package com.google.trial.jenkin;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.co.in/");

	}

	@Test(priority = 2,invocationCount = 2)
	public void verifyPageTitle() {

		String Title = driver.getTitle();

		Assert.assertEquals(Title, "Google");

	}
	@Test(priority = 1,invocationCount = 2)
	public void verifylogo() {
		
		WebElement logo=driver.findElement(By.cssSelector("img[alt='Google']"));
		
		Boolean isdiplayed=logo.isDisplayed();
		
		Assert.assertTrue(isdiplayed);
	}
	
	
	//comment added
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
