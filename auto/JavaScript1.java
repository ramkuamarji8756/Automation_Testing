package com.auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript1 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();// Maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies(); // Delete All Cookies
		driver.get("https://www.facebook.com"); // Open URL

		// Introduce JavaScriptExecuter interface and casting the interfaces
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		// Locate Web Element Using JavaScript
		jse.executeScript("document.getElementById('email').value='abc@gmail.com'");
		jse.executeScript("document.getElementById('pass').value='15454'");

         // Scroll down using JavaScript 
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,400)");
		
		 // Scroll Up using JavaScript 
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,-400)");
		
		
	}

}
