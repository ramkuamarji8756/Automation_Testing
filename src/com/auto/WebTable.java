package com.auto;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();// Maximize the window

        // Apply implicit wait (valid in Selenium 3.x)
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	       
        driver.get("https://money.rediff.com/gainers"); // Open URL
        
        // Create a list of All Companies
        List<WebElement> allCompanies=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]/a"));
        System.out.println(" Total  number of Companies = "+allCompanies.size());

     // Create a list of All Current 
        List<WebElement> allCurrentPrice = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
        System.out.println(" Total number of  Current Price = "+allCurrentPrice.size());

        String expectedCompanyName="DCM Shriram";
        for (int i = 0; i < allCompanies.size(); i++) 
        {
			if (allCompanies.get(i).getText().equalsIgnoreCase(expectedCompanyName))
			{
				System.out.println(allCompanies.get(i).getText()+"======"+allCurrentPrice.get(i).getText());
				Thread.sleep(2000);
				
			//	allCompanies.get(i).click();  //this line  clicl() gives error because it is older version 
				
				
				// this is replacement for above line
				WebElement targetCompany = allCompanies.get(i);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetCompany);
				Thread.sleep(500); // allow time for scroll
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", targetCompany);

			   break;
			
			}
		}
        
        
	}

}
