package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.Set;

public class MultipleWindowsExample {

    public static void main(String[] args) {
        // Auto-manage ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open local HTML from resources
            String url = Paths.get("src", "main", "resources", "multi_tab_form.html")
                              .toAbsolutePath()
                              .toUri()
                              .toString();
            driver.get(url);
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Store the main window handle
            String mainWindow = driver.getWindowHandle();

            // Click all five links to open new tabs/windows
            driver.findElement(By.id("link1")).click();
            driver.findElement(By.id("link2")).click();
            driver.findElement(By.id("link3")).click();
            driver.findElement(By.id("link4")).click();
            driver.findElement(By.id("link5")).click();

            // Wait until 6 windows exist (1 main + 5 children)
            wait.until(ExpectedConditions.numberOfWindowsToBe(6));

            // Switch to each child window, log title, then close it
            Set<String> allWindows = driver.getWindowHandles();
            for (String handle : allWindows) {
                if (!handle.equals(mainWindow)) {
                    driver.switchTo().window(handle);
                    System.out.println("Switched to child window | Title: " + driver.getTitle());
                    driver.close(); // Close child
                    System.out.println("Closed child window.");
                }
            }

            // Switch back to the main window
            driver.switchTo().window(mainWindow);
            System.out.println("Back on main window | Title: " + driver.getTitle());

            // (Optional) Interact with main page after returning
            driver.findElement(By.id("username")).sendKeys("TestUser");
            System.out.println("Typed into main window input.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

