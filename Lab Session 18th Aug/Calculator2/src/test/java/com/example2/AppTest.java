package com.example2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class AppTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Load local file
        File htmlFile = new File("C:\\selenium_test\\table.html");
        String url = "file:///" + htmlFile.getAbsolutePath();
        driver.get(url);
    }

    @Test
    public void readTableData() {
        // locate all rows inside tbody
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeeTable']/tbody/tr"));

        // iterate each row
        for (WebElement row : rows) {
            // get all cells (td) in current row
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // print each cell value
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "    ");
            }
            System.out.println();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}