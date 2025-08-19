package com.example2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;

public class XPathExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Load local HTML file
            File htmlFile = new File("src/test/resources/example.html");
            String url = "file:///" + htmlFile.getAbsolutePath();
            driver.get(url);

            // Locate username field using XPath
            WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Enter your username']"));
            usernameField.sendKeys("admin");

            // Locate password field using XPath
            WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
            passwordField.sendKeys("admin123");

            // Locate button using XPath
            WebElement loginButton = driver.findElement(By.xpath("//input[@value='Sign In']"));
            loginButton.click();

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
