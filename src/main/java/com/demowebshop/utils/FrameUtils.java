package com.demowebshop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameUtils {

    public static void switchToFrameByIndex(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    public static void switchToFrameByNameOrId(WebDriver driver, String name) {
        driver.switchTo().frame(name);
    }

    public static void switchToFrameByElement(WebDriver driver, By locator) {
        WebElement frame = driver.findElement(locator);
        driver.switchTo().frame(frame);
    }

    public static void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }
}