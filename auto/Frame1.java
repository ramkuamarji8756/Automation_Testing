package com.auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame1 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();// Maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://paytm.com/");   
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//*[text()='Sign In']")).click();
        Thread.sleep(3000);
		
        // find the total Number of  Frame present on web Page
        int totalFrames=driver.findElements(By.tagName("iframe")).size();
        System.out.println(totalFrames);
        
        for (int i = 0; i < totalFrames; i++) 
        {
        	driver.switchTo().frame(i);
        	Thread.sleep(3000);
        	driver.findElement(By.xpath("//*[contains(text),'Watch Video']")).click();// This is not work because paytm interface is changed 
			
		}
        
	}

}
