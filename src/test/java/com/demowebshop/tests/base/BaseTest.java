package com.demowebshop.tests.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.demowebshop.driver.DriverFactory;
import com.demowebshop.utils.ElementUtils;

public class BaseTest {

    @BeforeClass
    public void setUp() {

        DriverFactory.initDriver();

        try {
            WebDriver driver = DriverFactory.getDriver();

            driver.manage().window().maximize();

            ElementUtils.openBaseUrl(driver);

        } catch (RuntimeException | Error e) {

            DriverFactory.quitDriver();
            throw e;
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}