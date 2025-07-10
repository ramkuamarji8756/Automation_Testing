package com.auto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandling {

	public static void main(String[] args) throws Exception {

		
		// Setting the property of chrome browser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64//chromedriver.exe");
		
		// getting instance of specific chrome driver
		WebDriver driver = new ChromeDriver();
		// for Maximize the window
		driver.manage().window().maximize();
		
		// open for URL
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		Thread.sleep(3000);
		// 1st way- Not recomonded but mostly used in industry use the same 
		List<WebElement> birthMonth=driver.findElements(By.xpath("//select[@id='month']/option"));
		System.out.println("Total Month  Values = "+birthMonth.size());
		birthMonth.get(7).click(); 
		System.out.println(birthMonth.get(1).isEnabled()); //true
		
		// 2nd  Way- Recomonded 
		WebElement bm = driver.findElement(By.xpath("//select[@id='month']"));
		 // Use the Select Class Constructor
		
		Select month=new Select(bm); //Parameter constructor
		// Select by visible text
		month.selectByVisibleText("Apr"); //Apr
		
		// Select By Value
		
		month.selectByValue("11"); // Nov
		
		//Select By Index.
		month.selectByIndex(9); // Oct
		
		// Get  current Selected Value from  DropDown
		System.out.println(month.getFirstSelectedOption().getText());
		
		// 3rd  Way- Will Store all dropeDown values in  a list	
		List<WebElement> dropeDown=month.getOptions();
		System.out.println(" Total DropDown Are: "+dropeDown.size());
		for (int i = 0; i < dropeDown.size(); i++)
		{
			 String dropDownValues =dropeDown.get(i).getText();
			 if (dropDownValues.equalsIgnoreCase("Aug")) {
				dropeDown.get(i).click();
				
				break;
				
			}
		}
		
		// 4th Way- Checking if  dropdown support multiple Selection or Not 
		 System.out.println(month.isMultiple()); //false
		 month.selectByVisibleText("Apr"); //Apr
		 month.selectByValue("11"); // Nov
		 month.selectByIndex(9); // Oct
		 
		 // Deselect the selected dropdown value
		
		 /* month.deselectByVisibleText("Apr"); //Apr
		 month.deselectByValue("11"); // Nov
		 month.deselectByIndex(9); // Oct
		 
		 month.deselectAll();*/
			
		// 5th Way
		
		 bm.sendKeys("Feb");
		 
		 // 6th way 
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//select[@id='month']")).sendKeys("Mar");
		
	}

}
