package com.demowebshop.tests.base;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.config.ConfigReader;

public class ConfigReaderTest{
	
    @Test
    public void verifyConfigurationProperties() {

        String url = ConfigReader.getProperty("base.url");
        String browser = ConfigReader.getProperty("browser");
        String timeout = ConfigReader.getProperty("explicit.wait");

        Assert.assertEquals(
                url,
                "https://demowebshop.tricentis.com"
        );
        Assert.assertEquals(browser, "chrome");
        Assert.assertEquals(timeout, "10");
        System.out.println("Application URL: " + url);
        System.out.println("Browser: " + browser);
        System.out.println("Explicit Wait: " + timeout);
    }
}