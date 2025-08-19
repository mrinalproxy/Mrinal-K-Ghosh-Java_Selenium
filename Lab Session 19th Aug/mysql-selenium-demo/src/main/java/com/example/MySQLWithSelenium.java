package com.example;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MySQLWithSelenium {

    public static void main(String[] args) {
        // --- DB config (change as needed) ---
        String jdbcUrl = "jdbc:mysql://localhost:3306/java_selenium?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String dbUser = "root";
        String dbPass = "Mrinal@9733";

        String dbUsername = null;
        String dbPassword = null;

        // 1) JDBC: fetch username/password
        try {
            // optional: ensure driver loaded (modern drivers auto-load, but safe)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found in classpath.");
            e.printStackTrace();
            return;
        }

        String query = "SELECT username, password FROM user_tbl WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, 1);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dbUsername = rs.getString("username");
                    dbPassword = rs.getString("password");
                } else {
                    System.err.println("No user found with id=1");
                    return;
                }
            }
        } catch (SQLException e) {
            System.err.println("JDBC error:");
            e.printStackTrace();
            return;
        }

        // 2) Selenium: open local HTML, fill form
        WebDriver driver = null;
        try {
            // Auto-download/resolve correct ChromeDriver binary
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

            // Build a cross-platform file:// URL for src/main/resources/login.html
            String htmlPath = Paths.get("src", "main", "resources", "login.html")
                    .toAbsolutePath().toUri().toString();

            System.out.println("Opening: " + htmlPath);
            driver.get(htmlPath);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement usernameInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.name("username"))
            );
            WebElement passwordInput = driver.findElement(By.name("password"));
            WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));

            // Type values fetched from DB
            usernameInput.clear();
            usernameInput.sendKeys(dbUsername);

            passwordInput.clear();
            passwordInput.sendKeys(dbPassword);

            submitBtn.click();

            // wait a little to see result (or wait for some element if your page navigates)
            Thread.sleep(2000);

            System.out.println("Tried login with: " + dbUsername + " / " + dbPassword);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                //driver.quit();
            }
        }
    }
}
