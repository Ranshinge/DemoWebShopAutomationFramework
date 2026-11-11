package com.demowebshop.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.demowebshop.config.ConfigReader;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static void initDriver() {

        if (DRIVER.get() != null) {
            throw new IllegalStateException("WebDriver is already initialized for this thread.");
        }

        String browser = ConfigReader.getProperty("browser").trim().toLowerCase();

        WebDriver driver;

        switch (browser) {

            case "chrome":

                ChromeOptions options = new ChromeOptions();

                // SSL Certificate Handling
                options.setAcceptInsecureCerts(true);

                // Headless Browser (Enable when required)
                // options.addArguments("--headless=new");

                driver = new ChromeDriver(options);
                break;

            case "firefox":

                driver = new FirefoxDriver();
                break;

            default:

                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        DRIVER.set(driver);
    }

    public static WebDriver getDriver() {

        WebDriver driver = DRIVER.get();

        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized for this thread.");
        }

        return driver;
    }

    public static void quitDriver() {

        WebDriver driver = DRIVER.get();

        try {

            if (driver != null) {
                driver.quit();
            }

        } finally {

            DRIVER.remove();
        }
    }
}