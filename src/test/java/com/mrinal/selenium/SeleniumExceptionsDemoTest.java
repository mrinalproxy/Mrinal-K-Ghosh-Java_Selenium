package com.mrinal.selenium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumExceptionsDemoTest extends AppTest {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumExceptionsDemoTest.class);

    @Test
    public void handlesNoSuchElementException() {
        logger.info("Starting test: handlesNoSuchElementException");
        driver.get("https://example.com");
        try {
            driver.findElement(By.id("nonexistent-id")).click();
            Assert.fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            logger.error("Caught NoSuchElementException - element id='nonexistent-id' not found", e);
        }
    }

    @Test
    public void handlesTimeoutException() {
        logger.info("Starting test: handlesTimeoutException");
        driver.get("https://example.com");
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("never-there")));
            Assert.fail("Expected TimeoutException");
        } catch (TimeoutException e) {
            logger.error("Caught TimeoutException waiting for element id='never-there'", e);
        }
    }

    @Test
    public void handlesElementNotInteractableException() {
        logger.info("Starting test: handlesElementNotInteractableException");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement input = driver.findElement(By.cssSelector("#input-example input")); // disabled initially
        try {
            input.sendKeys("Hello");
            Assert.fail("Expected ElementNotInteractableException");
        } catch (ElementNotInteractableException e) {
            logger.error("Caught ElementNotInteractableException - input is not interactable", e);
            // Recover: enable then type
            driver.findElement(By.cssSelector("#input-example button")).click(); // Enable
            input = Waits.waitClickable(driver, By.cssSelector("#input-example input"), 10);
            input.sendKeys("Now enabled");
            logger.info("Successfully typed after enabling input");
        }
    }

    @Test
    public void handlesStaleElementReferenceException() {
        logger.info("Starting test: handlesStaleElementReferenceException");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = driver.findElement(By.cssSelector("#checkbox-example #checkbox"));
        driver.findElement(By.cssSelector("#checkbox-example button")).click(); // Remove checkbox
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(checkbox));
        try {
            // Using old reference after DOM change triggers StaleElementReferenceException
            checkbox.isDisplayed();
            Assert.fail("Expected StaleElementReferenceException");
        } catch (StaleElementReferenceException e) {
            logger.error("Caught StaleElementReferenceException - element reference is stale", e);
            // Recover by re-adding and re-locating the element
            driver.findElement(By.cssSelector("#checkbox-example button")).click(); // Add back
            WebElement newCheckbox = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkbox-example #checkbox")));
            Assert.assertTrue(newCheckbox.isDisplayed());
            logger.info("Recovered from stale element by re-locating it");
        }
    }

    @Test
    public void handlesWebDriverException() {
        logger.info("Starting test: handlesWebDriverException");
        driver.get("https://example.com");
        driver.quit(); // Intentionally close session
        try {
            driver.get("https://example.com"); // Using a quit driver triggers WebDriverException
            Assert.fail("Expected WebDriverException");
        } catch (WebDriverException e) {
            logger.error("Caught WebDriverException - driver session closed or crashed", e);
        } finally {
            logger.info("Finished handlesWebDriverException test");
        }
    }
}