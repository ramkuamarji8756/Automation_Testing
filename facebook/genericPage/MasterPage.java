package com.facebook.genericPage;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MasterPage 
{
	public static  WebDriver driver;
	public Properties prop;
	public Properties or;
	
	//constructer 
	public MasterPage() throws Exception 
	{
		// Configure  properties File 
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir") + "\\src\\com\\facebook\\repository\\configuration.properties");
		prop= new Properties();
		prop.load(ip);
		
		// Configure  properties File 
				FileInputStream fs=new FileInputStream(System.getProperty("user.dir") + "\\src\\com\\facebook\\repository\\locators.properties");
				or= new Properties();
				or.load(fs);
	
				if(prop.getProperty("browser").equalsIgnoreCase("chrome")) 
				{
					//System.getProperty("webdriver.chrome.driver", "D:\\Workspace2\\Automation01\\com.facebook.drivers\\chromedriver.exe");
					System.setProperty("webdriver.chrome.driver", "D:\\Workspace2\\Automation01\\com.facebook.drivers\\chromedriver.exe");

					driver= new ChromeDriver();
				}
				else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) 
				{
					System.getProperty("webdriver.gecko.driver", "D:\\Workspace2\\Automation01\\com.facebook.drivers\\geckodriver.exe");
				
					driver= new FirefoxDriver();
				}
				else 
				{
					System.out.println("Open IE Browser ");
				}
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get("https://www.facebook.com/");
	}

	public void click(String xpathKey) 
	{
		driver.findElement(By.xpath(or.getProperty(xpathKey))).click();
		
	}
	
	public void enterData(String xpathKey,String data) 
	{
		driver.findElement(By.xpath(or.getProperty(xpathKey))).sendKeys(data);;
		
	}
	
	public void clearData(String xpathKey) 
	{
		driver.findElement(By.xpath(or.getProperty(xpathKey))).click();		
	}
	
	public void moveToElement(String xpathKey) 
	{
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(or.getProperty(xpathKey)))).build().perform();
		
	}
	
	public void checkListElement(String xpathKey, String data) 
	{
		
		
		List<WebElement>  radios = driver.findElements(By.xpath(xpathKey));
		
		for (int i = 0; i < radios.size(); i++) 
		{
			if(radios.get(i).getText().equalsIgnoreCase(or.getProperty(data))) 
			{
				radios.get(i).click();
			}
			
		}
	}
	
	public void verifyEqualAssert(String a,String b) 
	{
		Assert.assertEquals(driver.findElement(By.xpath(or.getProperty(a))).getText(), or.getProperty(b));
	}
}
