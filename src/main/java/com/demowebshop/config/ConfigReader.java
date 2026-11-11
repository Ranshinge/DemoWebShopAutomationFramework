package com.demowebshop.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader 
{

    private static final String CONFIG_FILE = "config.properties";

    private static final Properties PROPERTIES = new Properties();

    static 
    {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) 
        {

            if (input == null) 
            {
                throw new IllegalStateException("Configuration file not found on classpath: "+ CONFIG_FILE);
            }

            PROPERTIES.load(input);

        }
        catch (IOException e) 
        {
            throw new IllegalStateException("Failed to load configuration file: "+ CONFIG_FILE, e);
        }
    }

    private ConfigReader() {
        // Prevent object creation
    }

    public static String getProperty(String key) 
    {
        String value = PROPERTIES.getProperty(key);

        if (value == null || value.isBlank()) 
        {
            throw new IllegalArgumentException("Missing or empty configuration property: " + key);
        }

        return value.trim();
    }
}