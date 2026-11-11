package com.demowebshop.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demowebshop.config.ConfigReader;

public class WaitUtils {

    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {

        int timeout = Integer.parseInt(ConfigReader.getProperty("explicit.wait"));

        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    // Wait Until Element Is Clickable
    public void waitUpToElementToBeClickable(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait Until Element Is Visible
    public void waitUpToElementToBeVisible(By locator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait For Alert And Accept
    public void waitForAlertAndAccept() {

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    // Wait Until Element Is Present
    public void waitForElementToBePresent(By locator) {

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait Until Element Becomes Invisible
    public void waitForInvisibility(By locator) {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Wait Until URL Contains Expected Text
    public void waitForUrlContains(String expectedUrl) {

        wait.until(ExpectedConditions.urlContains(expectedUrl));
    }
}