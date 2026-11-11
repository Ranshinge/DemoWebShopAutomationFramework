package com.demowebshop.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableUtils {

    // 1. Get Total Rows
    public static int getTotalRows(WebDriver driver, By locator) {

        List<WebElement> rows = driver.findElements(locator);

        return rows.size();
    }

    // 2. Get Total Columns
    public static int getTotalColumns(WebDriver driver, By locator) {

        List<WebElement> columns = driver.findElements(locator);

        return columns.size();
    }

    // 3. Get Cell Data
    public static String getCellData(WebDriver driver, By locator) {

        String cellData = driver.findElement(locator).getText();

        return cellData;
    }

    // 4. Get Row Data
    public static List<String> getRowData(WebDriver driver, By locator) {

        List<WebElement> cells = driver.findElements(locator);

        List<String> rowData = new ArrayList<>();

        for (WebElement cell : cells) {
            rowData.add(cell.getText());
        }

        return rowData;
    }

    // 5. Get Column Data
    public static List<String> getColumnData(WebDriver driver, By locator) {

        List<WebElement> cells = driver.findElements(locator);

        List<String> columnData = new ArrayList<>();

        for (WebElement cell : cells) {
            columnData.add(cell.getText());
        }

        return columnData;
    }

    // 6. Verify Table Data
    public static boolean verifyTableData(WebDriver driver, By locator, String expectedData) {

        String actualData = driver.findElement(locator).getText();

        return actualData.equals(expectedData);
    }

    // 7. Search Value in Table
    public static boolean searchValueInTable(WebDriver driver, By locator, String searchValue) {

        List<WebElement> cells = driver.findElements(locator);

        for (WebElement cell : cells) {

            if (cell.getText().equals(searchValue)) {
                return true;
            }
        }

        return false;
    }
}