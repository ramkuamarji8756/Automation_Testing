package com.auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseSimulation1 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();// Maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/elec-b2b-store?fm=neo%2Fmerchandising&iid=M_da547e65-b729-4773-81ea-0ab179ae4f52_1_372UD5BXDFYS_MC.1B9DW42USMK1&otracker=hp_rich_navigation_2_1.navigationCard.RICH_NAVIGATION_Electronics~Electronics%2BGST%2BStore_1B9DW42USMK1&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L1_view-all&cid=1B9DW42USMK1"); // Open URL
        
		// Creating Web Element reference
		
		WebElement Electronics = driver.findElement(By.xpath("//*[text()='Electronics']"));
		
		// Mouse Simulation Using Action Class
		Actions act= new Actions(driver); 
		
		Thread.sleep(3000);
		// Mouse Hover to Electronics Web Element
		act.moveToElement(Electronics).build().perform();
		
		
		Thread.sleep(3000);
		// Right click on  Web Element
		act.contextClick(Electronics).build();
		
		// Release Control from Web Element
		Thread.sleep(3000);
		act.release(Electronics).build().perform();
		
		// Perfom Key Events
		Thread.sleep(3000);
		act.sendKeys(Keys.ENTER).build().perform();
		
		// Press Enter Keys to Home & furniture Web Element
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
	WebElement home= driver.findElement(By.xpath("//*[text()='Home & Furniture']"));
	Thread.sleep(3000);
	act.sendKeys(home,Keys.ENTER).build().perform();
	System.out.println(" Home Menu Clicked");
	
		
	}

}
