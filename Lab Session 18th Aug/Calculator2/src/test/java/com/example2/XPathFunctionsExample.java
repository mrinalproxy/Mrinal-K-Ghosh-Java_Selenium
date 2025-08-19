package com.example2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;

public class XPathFunctionsExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Load local HTML file
            File htmlFile = new File("src/test/resources/example.html");
            String url = "file:///" + htmlFile.getAbsolutePath();
            driver.get(url);

            // Example of contains() - locate username
            WebElement usernameField = driver.findElement(By.xpath("//input[contains(@placeholder,'username')]"));
            usernameField.sendKeys("testuser");

            // Example of contains() - locate password
            WebElement passwordField = driver.findElement(By.xpath("//input[contains(@placeholder,'password')]"));
            passwordField.sendKeys("testpass");

            // Example of text() - locate link
            WebElement forgotLink = driver.findElement(By.xpath("//a[text()='Forgot Password?']"));
            forgotLink.click();

            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
