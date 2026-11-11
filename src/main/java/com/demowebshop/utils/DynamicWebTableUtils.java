package com.demowebshop.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicWebTableUtils {

    // Dynamic Web Table

    public static List<WebElement> getDynamicTableRows(WebDriver driver, By locator) {

        List<WebElement> rows = driver.findElements(locator);

        return rows;
    }

    public static boolean searchValueInDynamicTable(WebDriver driver, By locator, String searchValue) {

        List<WebElement> cells = driver.findElements(locator);

        for (WebElement cell : cells) {

            if (cell.getText().equals(searchValue)) {
                return true;
            }
        }

        return false;
    }

    // Pagination

    public static void clickNextPage(WebDriver driver, By locator) {

        driver.findElement(locator).click();
    }

    public static void clickPreviousPage(WebDriver driver, By locator) {

        driver.findElement(locator).click();
    }

    public static void clickPageNumber(WebDriver driver, By locator) {

        driver.findElement(locator).click();
    }

    public static boolean isNextButtonEnabled(WebDriver driver, By locator) {

        return driver.findElement(locator).isEnabled();
    }

    public static boolean isPreviousButtonEnabled(WebDriver driver, By locator) {

        return driver.findElement(locator).isEnabled();
    }
}