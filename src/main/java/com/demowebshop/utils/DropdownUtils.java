package com.demowebshop.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtils {

    public static void selectByVisibleText(WebDriver driver, By locator, String visibleText) {
        WebElement dropElement = driver.findElement(locator);
        Select option = new Select(dropElement);
        option.selectByVisibleText(visibleText);
    }

    public static void selectByValue(WebDriver driver, By locator, String value) {
        WebElement dropElement = driver.findElement(locator);
        Select option = new Select(dropElement);
        option.selectByValue(value);
    }

    public static void selectByIndex(WebDriver driver, By locator, int index) {
        WebElement dropElement = driver.findElement(locator);
        Select option = new Select(dropElement);
        option.selectByIndex(index);
    }

    public static boolean verifyBootstrapDropdownOptions(
            WebDriver driver, By dropdownLocator, By optionsLocator,
            List<String> expectedOptions) {

        driver.findElement(dropdownLocator).click();

        List<WebElement> options = driver.findElements(optionsLocator);
        List<String> actualOptions = new ArrayList<>();
        Set<String> uniqueOptions = new HashSet<>();

        for (WebElement option : options) {
            String op = option.getText().trim();
            actualOptions.add(op);

            if (expectedOptions.contains(op)) {
                System.out.println(op + " - Verified");
            } else {
                System.out.println(op + " - Unexpected Option");
            }

            if (!uniqueOptions.add(op)) {
                System.out.println("Duplicate Option: " + op);
            }
        }

        List<String> missingOptions = new ArrayList<>(expectedOptions);
        missingOptions.removeAll(actualOptions);

        if (!missingOptions.isEmpty()) {
            System.out.println("Missing Options: " + missingOptions);
        }

        boolean result = expectedOptions.equals(actualOptions);

        System.out.println("Dropdown Verification Result: " + result);

        return result;
    }

    public static void selectBootstrapDropdownOption(
            WebDriver driver, By dropdownLocator, By optionLocator) {

        driver.findElement(dropdownLocator).click();
        driver.findElement(optionLocator).click();
    }
}