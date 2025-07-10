package com.auto;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

    public static void main(String[] args) throws InterruptedException {

        // Set path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Apply implicit wait (valid in Selenium 3.x)
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Open Google
        driver.get("https://www.google.com");

        // Type search query
        driver.findElement(By.name("q")).sendKeys("How Stuff works");

        // Wait briefly to let suggestions load
        Thread.sleep(2000);

        // Get auto-suggestions
        List<WebElement> allSearch = driver.findElements(By.xpath("//ul[@role='listbox']//li"));

        System.out.println("Total Auto Suggestions Displayed: " + allSearch.size());

        // Target suggestion
        String expectedSearchText = "How Stuff works";

        // Iterate and click
        for (WebElement suggestion : allSearch) {
            String suggestionText = suggestion.getText().toLowerCase();

            System.out.println("==========");
            if (suggestionText.equalsIgnoreCase(expectedSearchText)) {
            	System.out.println("=============");
                suggestion.click();
                System.out.println("You have clicked on: " + expectedSearchText);
                break;
            }
        }

        
    }
}
