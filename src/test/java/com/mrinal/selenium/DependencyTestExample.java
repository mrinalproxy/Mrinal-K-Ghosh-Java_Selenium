package com.mrinal.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.net.URL;
import java.time.Duration;


public class DependencyTestExample extends AppTest {


@Test
public void launchWebsite() {
// load the test HTML from classpath
URL page = getClass().getClassLoader().getResource("emppage.html");
Assert.assertNotNull(page, "emppage.html not found in src/test/resources");


driver.get(page.toString()); // file:/... or jar:file:/... handled transparently


String expectedTitle = "Employee Page";
String actualTitle = driver.getTitle();
Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
}


@Test(dependsOnMethods = {"launchWebsite"})
public void performLogin() {
// fill user and password and click login
driver.findElement(By.id("username")).sendKeys("admin");
driver.findElement(By.id("password")).sendKeys("admin123");
driver.findElement(By.id("loginBtn")).click();


// wait for dashboard to appear
WebElement dashboard = new WebDriverWait(driver, Duration.ofSeconds(5))
.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));


Assert.assertTrue(dashboard.isDisplayed(), "Dashboard should be visible after login");
}


@Test(dependsOnMethods = {"performLogin"})
public void verifyDashboard() {
WebElement welcome = driver.findElement(By.id("welcomeMsg"));
Assert.assertTrue(welcome.getText().contains("Welcome"), "Welcome message missing");
}
}