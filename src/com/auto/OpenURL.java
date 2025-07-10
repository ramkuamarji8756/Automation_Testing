package com.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenURL {

	public static void main(String[] args) throws Exception
	{

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64//chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		// get the UrL of page
		String currentUrl = driver.getCurrentUrl();
		System.out.println(" Current URL: "+currentUrl);
		
		//Thread.sleep for specific time interval
		Thread.sleep(3000);
		
		// Navigate from one page to another
		driver.navigate().to("https://www.google.com/search");
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		
				// Forword
				Thread.sleep(2000);
				driver.navigate().forward();
				// Backword
				Thread.sleep(2000);
				driver.navigate().back();
				
				
				// getting Title
				Thread.sleep(2000);
				String title = driver.getTitle();
				System.out.println(" Title: "+title);
				
				// Locate Web Element
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("raj@gmail.com");
				
				// Get the TagName of specific web Element
				String tagName = driver.findElement(By.xpath("//input[@id='email']")).getTagName();
				System.out.println(" TagName = "+tagName);
				
				
		// close the current window
		Thread.sleep(2000);
		driver.close();
		
		// Close the all Windows
		
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}
