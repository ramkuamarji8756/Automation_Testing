package com.auto;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseSimulation3 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();// Maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://jqueryui.com/droppable/");        
		
        // Switching frame
        List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));
        System.out.println(" Total Frames Available on Web Page: "+allFrames.size());
        
        for (int i = 0; i < allFrames.size(); i++) 
        {
        	driver.switchTo().frame(i);
        	if(driver.findElement(By.id("draggable")).isDisplayed() && driver.findElement(By.id("droppable")).isDisplayed())
        	{
        		Thread.sleep(3000);
        		Actions act= new Actions(driver);
        		act.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
        		
        		System.out.println("Element found in : "+(i+1)+" frame");
        	}
			
		}
		
	}

}
