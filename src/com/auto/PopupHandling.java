package com.auto;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupHandling {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();// Maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.naukri.com/"); 
        
        //Print how many Windows are Opened
        Thread.sleep(3000);
        Set<String> popUpId = driver.getWindowHandles();
        System.out.println(" Popup Id : "+popUpId);
        System.out.println(" Popup Id  size: "+popUpId.size());
        Iterator<String> abc= popUpId.iterator();
        
        String window1=abc.next();
//        String window2=abc.next();
//        String window3=abc.next();
//        String window4=abc.next();
        
        
        // Print the title of popup Window 2
       // driver.switchTo().window(window2);  
        System.out.println(window1);//AlphaNumeric id for pop Window 2
        System.out.println(driver.getTitle());
        
        Thread.sleep(3000);
        driver.close();
        
        

        
	}

}
