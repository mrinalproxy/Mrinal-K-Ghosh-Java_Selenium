package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeFormTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\SeleniumTest\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("file:///E:/SeleniumTest/Employees.html");

            EmployeeFormPage formPage = new EmployeeFormPage(driver);

            formPage.enterEmpId("101");
            formPage.enterEmpName("Harry");
            formPage.enterDOB("2001-01-11");
            formPage.enterAddress("123 ABC");
            formPage.enterContactNo("7777777777");
            formPage.enterEmail("harry@example.com");
            formPage.clickSubmit();

            Thread.sleep(1000);

            String message = formPage.getConfirmationMessage();
            if (message != null) {
                System.out.println("Success: " + message);
            } else {
                System.out.println("Submission failed or message not shown.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}