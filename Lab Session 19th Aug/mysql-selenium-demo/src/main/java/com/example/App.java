package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Load local HTML
            File file = new File("src/main/resources/dragdrop.html");
            String url = "file:///" + file.getAbsolutePath();
            driver.get(url);
            driver.manage().window().maximize();

            // ---------- Trainer's Original Code ----------
            WebElement dragElement1 = driver.findElement(By.id("drag"));
            WebElement dropElement1 = driver.findElement(By.id("drop"));

            Actions actions1 = new Actions(driver);
            actions1.dragAndDrop(dragElement1, dropElement1).perform();
            Thread.sleep(2000); // Trainer's sleep

            System.out.println("drag & drop executed");

            // ---------- Improved Code ----------
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement dragElement2 = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("drag")));
            WebElement dropElement2 = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("drop")));

            // Method 1: Standard dragAndDrop
            Actions actions2 = new Actions(driver);
            actions2.dragAndDrop(dragElement2, dropElement2).perform();

            // Verify result
            wait.until(ExpectedConditions.textToBePresentInElement(dropElement2, "Dropped!"));
            System.out.println("✅ Improved drag & drop successful using dragAndDrop()");

            // Optional: Try Method 2 - clickHold & moveToElement
            driver.navigate().refresh(); // reload page for second test
            dragElement2 = driver.findElement(By.id("drag"));
            dropElement2 = driver.findElement(By.id("drop"));

            actions2.clickAndHold(dragElement2)
                    .moveToElement(dropElement2)
                    .release()
                    .build()
                    .perform();

            wait.until(ExpectedConditions.textToBePresentInElement(dropElement2, "Dropped!"));
            System.out.println("Improved drag & drop successful using clickHold/moveToElement");

        } catch (Exception e) {
            System.out.println(" Test failed: " + e.getMessage());
        } finally {
            //driver.quit();
        }
    }
}
