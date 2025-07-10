package com.auto;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObjectRepository {

	public static void main(String[] args) throws Exception
	{
      
		ObjectRepository objectRepository= new ObjectRepository();
		// Specify the Properties file
		File src=new File("D:\\Workspace2\\Automation01\\Repository\\Object_Repo.properties");
         // Create FileinputeStream class object to load the file
		FileInputStream fis=new FileInputStream(src);
		
	  // Create Properties class object to read properties file
		Properties pro =new Properties();
		pro.load(fis);
		
		// Setting the properties of chrome browser  and passing the ChromeDriver path
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();// Maximize the window
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
        objectRepository.openURL(driver, pro.getProperty("URL1"));
         Thread.sleep(3000);
         objectRepository.openURL(driver, pro.getProperty("URL"));

         Thread.sleep(3000);
         
         // getProperties() method accept key and it returns value for same key
        driver.findElement(By.xpath(pro.getProperty("Email"))).sendKeys(pro.getProperty("EmailTestData"));
        driver.findElement(By.xpath(pro.getProperty("Password"))).sendKeys(pro.getProperty("PasswordTestData"));
        Thread.sleep(3000);
        driver.quit();
	
	}
	//Open Url
	public void openURL(WebDriver driver, String url)
	{
		driver.get(url);
	}
	
}
