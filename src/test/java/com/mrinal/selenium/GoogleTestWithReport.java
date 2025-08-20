package com.mrinal.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GoogleTestWithReport {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        // Use SparkReporter instead of HtmlReporter (new in ExtentReports v5)
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() {
        test = extent.createTest("Open Google", "Verify Google homepage loads successfully");

        driver.get("https://www.google.com");
        String title = driver.getTitle();

        if (title.contains("Google")) {
            test.pass("Google homepage opened successfully. Title: " + title);
        } else {
            test.fail("Google homepage title did not match. Actual Title: " + title);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush(); // write everything to the report
    }
}
