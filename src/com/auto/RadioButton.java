package com.auto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) throws Exception 
	{
		
		//Setting the properties of browser and passing chromeDriver path
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64//chromedriver.exe");
		
		//Launching the Chromr Browser Instance
		WebDriver driver =new ChromeDriver();
		
		// manage()- to maximize the window 
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		// Open URL of application using get()  and navigate() method 
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		
		//1st way
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='1']")).click(); //It will click on Female Radio button
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@value='2']")).click(); //It will click on Male Radio button
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@value='-1']")).click(); //It will click on custome Radio button
				
				
				// 2nd Way-By creating list of all radio button
				List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
	             System.out.println("Total Radio Button =: "+radios.size());
	             
	             System.out.println(radios.get(1).isEnabled()); // Male is enable or Not
	             System.out.println(radios.get(0).isDisplayed()); // Female is displayed or Not
	             System.out.println(radios.get(2).isSelected()); // Custom is Selected or Not
	             Thread.sleep(3000);
	             
	             radios.get(1).click(); // Male
	             Thread.sleep(3000);
	             
	             System.out.println(radios.get(2).isSelected()); //Custom is Selected  or Not 
	             

	             // 3rd Way Correct way
	             List<WebElement> radios1 = driver.findElements(By.xpath("//label[contains(@class,'mt')]"));
	             String expectedResult= "Female";
	             for (int i = 0; i < radios1.size(); i++)
	             {
	            	 if(radios1.get(i).getText().equalsIgnoreCase(expectedResult)) 
	            	 {
	            		 radios1.get(i).click();
	            		 System.out.println(expectedResult+" Clicked");
	            		 break;
	            	 }
					
				}
	             Thread.sleep(3000);
	             driver.close();
	}

}
