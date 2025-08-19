package com.example2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SeleniumLocalHtmlByXpath {

    @Test
    public void testLocalHtmlFile() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
        	File htmlFile = new File("src/test/resources/myhtml.html");
        	String url = "file:///" + htmlFile.getAbsolutePath();
        	driver.get(url);

            WebElement inputField = driver.findElement(By.xpath("//input[@id='searchBox']"));
            inputField.sendKeys("Hello Learners!");

            WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-button']"));
            searchButton.click();

            Thread.sleep(3000);
        } finally {
            //driver.quit();
        }
    }
}