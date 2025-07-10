package com.auto;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseSimulation2 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();// Maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://jqueryui.com/draggable/");        
		
        // Switching frame
        List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));
        System.out.println(" Total Frames Available on Web Page: "+allFrames.size());
        driver.switchTo().frame(0);
        
        // Will Find  Dragable Web element
        WebElement draggableElement=driver.findElement(By.id("draggable"));
        Thread.sleep(3000);
        
        // Using Action class, drag the Element
        Actions act= new Actions(driver);
        act.dragAndDropBy(draggableElement, 30, 20).build().perform();
      // drag the Web Element and click and hold using coordinates
        Thread.sleep(3000);
        act.clickAndHold(draggableElement).dragAndDropBy(draggableElement, 30, 30).build().perform();
		
	}

}
