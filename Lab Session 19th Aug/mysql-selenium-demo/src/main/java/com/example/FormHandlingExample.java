package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class FormHandlingExample {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            // Load the local HTML file from resources
            File file = new File("src/main/resources/form.html");
            String url = "file:///" + file.getAbsolutePath();
            driver.get(url);
            driver.manage().window().maximize();

            // ---------------- Radio Button ----------------
            WebElement maleRadio = driver.findElement(By.id("male"));
            if (!maleRadio.isSelected()) {
                maleRadio.click();
            }

            // ---------------- Checkbox ----------------
            WebElement agreeCheckbox = driver.findElement(By.id("agree"));
            if (!agreeCheckbox.isSelected()) {
                agreeCheckbox.click();
            }

            // ---------------- Dropdown ----------------
            WebElement countryDropdownElement = driver.findElement(By.id("country"));
            Select countryDropdown = new Select(countryDropdownElement);
            countryDropdown.selectByVisibleText("India");

            // Print selected country
            WebElement selected = countryDropdown.getFirstSelectedOption();
            System.out.println("Selected Country: " + selected.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            //driver.quit();
        }
    }
}
