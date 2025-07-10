package com.auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();// Maximize the window

	        // Apply implicit wait (valid in Selenium 3.x)
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	       
	        driver.get("https://www.facebook.com"); // Open Facebook

	        // Enter UserName
	        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
	    
	        // Use Explicit wait to check if password field is visible and enter password
	        WebDriverWait wt= new WebDriverWait(driver,30); 
	        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='wrongpass']"))).sendKeys("12345");
	        
	
	
	}

}
