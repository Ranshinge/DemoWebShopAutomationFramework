package com.demowebshop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demowebshop.config.ConfigReader;

public class ElementUtils {

    // Browser Navigation Methods

    public static void openBaseUrl(WebDriver driver) {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    public static void closeCurrentWindow(WebDriver driver) {
        driver.close();
    }

    public static void navigateToBaseUrl(WebDriver driver) {
        driver.navigate().to(ConfigReader.getProperty("base.url"));
    }

    public static void navigateBack(WebDriver driver) {
        driver.navigate().back();
    }

    public static void navigateForward(WebDriver driver) {
        driver.navigate().forward();
    }

    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    // Conditional Methods

    public static boolean isElementDisplayed(WebDriver driver, By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public static boolean isElementEnabled(WebDriver driver, By locator) {
        return driver.findElement(locator).isEnabled();
    }

    public static boolean isElementSelected(WebDriver driver, By locator) {
        return driver.findElement(locator).isSelected();
    }

    // Browser Get Methods

    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    // Element Get Methods

    public static String getText(WebDriver driver, By locator) {
        return driver.findElement(locator).getText();
    }

    public static String getAttributeValue(WebDriver driver, By locator, String attributeName) {
        return driver.findElement(locator).getAttribute(attributeName);
    }

    public static String getTagName(WebDriver driver, By locator) {
        return driver.findElement(locator).getTagName();
    }

    public static String getCssPropertyValue(WebDriver driver, By locator, String propertyName) {
        return driver.findElement(locator).getCssValue(propertyName);
    }

    // Element Interaction Methods

    public static void clickElement(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }

    public static void enterText(WebDriver driver, By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public static void clearText(WebDriver driver, By locator) {
        driver.findElement(locator).clear();
    }
}