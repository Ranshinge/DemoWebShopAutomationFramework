package com.demowebshop.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectionUtils {

    public static void selectCheckbox(WebDriver driver, By locator) {
        WebElement checkbox = driver.findElement(locator);

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public static void toggleCheckbox(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }

    public static void selectAllCheckboxes(WebDriver driver, By locator) {
        List<WebElement> checkboxes = driver.findElements(locator);

        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public static void unselectAllCheckboxes(WebDriver driver, By locator) {
        List<WebElement> checkboxes = driver.findElements(locator);

        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public static void selectFirstNCheckboxes(WebDriver driver, By locator, int number) {
        List<WebElement> checkboxes = driver.findElements(locator);

        if (number < 0 || number > checkboxes.size()) {
            throw new IllegalArgumentException("Invalid checkbox count");
        }

        for (int i = 0; i < number; i++) {
            WebElement checkbox = checkboxes.get(i);

            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public static void selectLastNCheckboxes(WebDriver driver, By locator, int number) {
        List<WebElement> checkboxes = driver.findElements(locator);

        if (number < 0 || number > checkboxes.size()) {
            throw new IllegalArgumentException("Invalid checkbox count");
        }

        int size = checkboxes.size();

        for (int i = size - number; i < size; i++) {
            WebElement checkbox = checkboxes.get(i);

            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public static void selectRadioButton(WebDriver driver, By locator) {
        WebElement radioButton = driver.findElement(locator);

        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }
}