package com.auto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingWritingExcel {

    public static void main(String[] args) throws Exception {

        // Load the Excel file
        File src = new File("C:\\Users\\Ramkumar\\Desktop\\Demo.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet("DemoSheet");

        // Print the sheet name
        System.out.println("Sheet Name: " + sh.getSheetName());

        // Read a value
        String username = sh.getRow(0).getCell(0).getStringCellValue();
        System.out.println("Username from Excel: " + username);

        // Get row and column counts
        int rows = sh.getLastRowNum() - sh.getFirstRowNum() + 1;
        int columns = sh.getRow(0).getLastCellNum();

        System.out.println("Total Rows: " + rows);
        System.out.println("Total Columns: " + columns);

        // Print all cell values
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(sh.getRow(i).getCell(j).getStringCellValue() + "\t");
            }
            System.out.println();
        }

        //  WRITE TO EXCEL: Writing "Tested" into column 3 (index 2) of each row
        for (int i = 0; i < rows; i++) {
            // Create a new cell in 3rd column if not already present
            if (sh.getRow(i).getCell(2) == null) {
                sh.getRow(i).createCell(2).setCellValue("Tested");
            } else {
                sh.getRow(i).getCell(2).setCellValue("Tested");
            }
        }

        // Save the changes in Excel
        fis.close(); // Close the input stream before writing
        FileOutputStream fos = new FileOutputStream(src);
        wb.write(fos);
        fos.close();
        wb.close();
        System.out.println("Excel updated successfully!");

        // --- Selenium Section ---
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com");

        // Using first cell from Excel to input email
        driver.findElement(By.id("email")).sendKeys(username);
        
        // Add a delay before closing browser (optional)
        Thread.sleep(3000);
        driver.quit();
    }
}
