package com.demowebshop.utils;

import org.openqa.selenium.WebDriver;

public class AlertUtils{
	
	public static void acceptSimpleAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public static void acceptConfirmationAlert(WebDriver driver)
	{
		acceptSimpleAlert(driver);
	}
	
	public static void dismissConfirmationAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static void enterTextInPromptAndAcceptAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
		acceptConfirmationAlert(driver);
	}
	
	public static void enterTextInPromptAndDismissAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
		dismissConfirmationAlert(driver);
	}
	
}
