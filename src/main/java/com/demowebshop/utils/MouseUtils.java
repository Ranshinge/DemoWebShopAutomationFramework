package com.demowebshop.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class MouseUtils {

    // Mouse Hover
    public static void mouseHover(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    // Right Click
    public static void rightClick(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
    }

    // Double Click
    public static void doubleClick(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    // Drag and Drop
    public static void dragAndDrop(WebDriver driver, By sourceLocator, By targetLocator) {

        WebElement source = driver.findElement(sourceLocator);
        WebElement target = driver.findElement(targetLocator);

        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).perform();
    }
}