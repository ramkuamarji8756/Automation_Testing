package com.auto;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingExcel {

	public static void main(String[] args) throws Exception {

		// Specify  the location of Excel file
		File src= new File("C:\\Users\\Ramkumar\\Desktop\\Demo.xlsx");
	// Load File
		FileInputStream fis = new FileInputStream(src);
	//Load WorkBook
		XSSFWorkbook wb =new XSSFWorkbook(fis);
		
		// Load the WorkSheet
		XSSFSheet sh= wb.getSheet("DemoSheet");
		
		// Print the name loaded sheet
		System.out.println(sh.getSheetName());
		
		// Print UserName from excel sheet
		System.out.println(sh.getRow(0).getCell(0).getStringCellValue());
	
		// Print p2 from excel sheet
				System.out.println(sh.getRow(2).getCell(1).getStringCellValue());
				
				// Print total number of row -1st way 
				System.out.println("Total Rows : "+sh.getPhysicalNumberOfRows());
			
				// Print total number of row -2nd way 
				System.out.println(sh.getLastRowNum());// Here index will work and output will be 5
				System.out.println(sh.getFirstRowNum()); //Here index will work and output will be 0 
			 int rows= (sh.getLastRowNum()-sh.getFirstRowNum()+1);
	System.out.println(" total Rows: "+rows);//6
	
	// print total number of rows - 3rd way
	System.out.println(" total Rows: "+(sh.getLastRowNum()+1));
	
	// Print total number of column -1st way
	System.out.println(" Total Columns : "+sh.getRow(0).getPhysicalNumberOfCells());
	
	// Print total number of columns -2nd  way
	
		System.out.println(" Total Columns : "+sh.getRow(0).getLastCellNum());
	
		
		// Print total number of column - 3rd way
		System.out.println(" Total Columns : "+sh.getRow(0).getPhysicalNumberOfCells());
		int columns=sh.getRow(0).getLastCellNum();
		
		System.out.println(" total Columns: "+columns);
		
		// print all cells of excell sheet
		for (int i = 0; i < rows; i++)
		{
		
			for (int j = 0; j < columns; j++)
			{
				System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
				
			}
		}
		
		
		// Setting the properties of chrome Browser and passing chromedriver path
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();// Maximize the window

	        // Apply implicit wait (valid in Selenium 3.x)
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	       
	        driver.get("https://www.facebook.com"); // Open Facebook

	        // enter userName using ExcelSheet
	        String a = sh.getRow(0).getCell(0).getStringCellValue();
	        driver.findElement(By.id("email")).sendKeys(a);
	        
	}

}
