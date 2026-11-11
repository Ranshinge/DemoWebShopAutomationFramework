package com.demowebshop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadUtils {

    public static void uploadFile(WebDriver driver, By locator, String filePath) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(filePath);
    }
}