package com.demowebshop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePickerUtils {

    // Enter Date (HTML Date Picker)
    public static void enterDate(WebDriver driver, By locator, String date) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(date);
    }

    // Get Selected Date
    public static String getSelectedDate(WebDriver driver, By locator) {
        String date = driver.findElement(locator).getAttribute("value");
        return date;
    }
}