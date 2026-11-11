package com.demowebshop.utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowOperationUtils {

    public static void switchToWindow(WebDriver driver, String expectedTitle)
    {
        Set<String> allWindowId = driver.getWindowHandles();

        for (String windowId : allWindowId)
        {
            driver.switchTo().window(windowId);

            String title = driver.getTitle();

            if (title.equals(expectedTitle))
            {
                return;
            }
        }

        throw new IllegalStateException("Window not found: " + expectedTitle);
    }

    public static String saveParentWindowId(WebDriver driver)
    {
        String parentId = driver.getWindowHandle();

        return parentId;
    }

    public static void switchBackToParentWindow(WebDriver driver, String parentId)
    {
        driver.switchTo().window(parentId);
    }

    public static Set<String> getAllWindowHandles(WebDriver driver)
    {
        Set<String> handles = driver.getWindowHandles();

        return handles;
    }
}