package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class IframeExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {
            // Load main.html
            File file = new File("src/main/resources/main.html");
            String url = "file:///" + file.getAbsolutePath();
            driver.get(url);
            driver.manage().window().maximize();

            // ---------------- Frame 1 ----------------
            driver.switchTo().frame("frame1");
            WebElement input1 = driver.findElement(By.id("input1"));
            input1.sendKeys("Hello Frame 1!");
            driver.switchTo().defaultContent(); // back to main page

            // ---------------- Frame 2 ----------------
            driver.switchTo().frame("frame2");
            WebElement input2 = driver.findElement(By.id("input2"));
            input2.sendKeys("Hello Frame 2!");
            driver.switchTo().defaultContent(); // back to main page

            // ---------------- Frame 3 ----------------
            driver.switchTo().frame("frame3");
            WebElement input3 = driver.findElement(By.id("input3"));
            input3.sendKeys("Hello Frame 3!");
            driver.switchTo().defaultContent(); // back to main page

            // Pause to see the result
            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}