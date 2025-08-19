package com.example.excelselenium;

import org.openqa.selenium.WebElement;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
 
public class App {
	static WebDriver driver;
 
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream(new File("TestSteps.xlsx"));
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);
 
			for (Row row : sheet) {
				if (row.getRowNum() == 0)
					continue; // skip header
 
				String keyword = row.getCell(1).getStringCellValue();
				String locatorType = getCellValue(row.getCell(2));
				String locatorValue = getCellValue(row.getCell(3));
				String data = getCellValue(row.getCell(4));
 
				executeStep(keyword, locatorType, locatorValue, data);
			}
 
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public static String getCellValue(Cell cell) {
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf((int) cell.getNumericCellValue());
		default:
			return "";
		}
	}
 
	public static void executeStep(String keyword, String locatorType, String locatorValue, String data) {
		switch (keyword.toLowerCase()) {
		case "openbrowser":
			// System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
			driver = new ChromeDriver();
			break;
 
		case "openurl":
			driver.get(data);
			break;
 
		case "inputtext":
			getElement(locatorType, locatorValue).sendKeys(data);
			break;
 
		case "click":
			getElement(locatorType, locatorValue).click();
			break;
 
		case "closebrowser":
			driver.quit();
			break;
 
		default:
			System.out.println("Unknown keyword: " + keyword);
		}
	}
 
	public static WebElement getElement(String type, String value) {
		switch (type.toLowerCase()) {
		case "id":
			return driver.findElement(By.id(value));
		case "name":
			return driver.findElement(By.name(value));
		case "cssselector":
			return driver.findElement(By.cssSelector(value));
		case "xpath":
			return driver.findElement(By.xpath(value));
		default:
			throw new IllegalArgumentException("Invalid locator type: " + type);
		}
	}
}
 
 