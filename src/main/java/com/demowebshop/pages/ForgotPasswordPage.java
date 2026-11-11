package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demowebshop.utils.ElementUtils;
import com.demowebshop.utils.WaitUtils;

public class ForgotPasswordPage extends BasePage {
	
	//Locators
	private By emailField = By.xpath("//input[@id='Email']");
	private By recoverButton = By.xpath("//input[@name='send-email']");
	
	
	private By validationSummaryMessage = By.xpath("//span[@for='Email']");
    private By resultMessage = By.xpath("//div[@class='result']"); 
	
	private WaitUtils waitUtil;
	public ForgotPasswordPage(WebDriver driver)
	{
		super(driver);
		waitUtil = new WaitUtils(driver);
	}
	
	public String recoverPasswordWithValidEmail(String validEmail)
	{
		waitUtil.waitUpToElementToBeClickable(emailField);
		ElementUtils.enterText(driver, emailField, validEmail);
		waitUtil.waitUpToElementToBeClickable(recoverButton);
		ElementUtils.clickElement(driver, recoverButton);
		waitUtil.waitUpToElementToBeVisible(resultMessage);
		return ElementUtils.getText(driver, resultMessage);	
	}
	
	public String recoverPasswordWithEmptyEmail()
	{
		waitUtil.waitUpToElementToBeClickable(emailField);
		waitUtil.waitUpToElementToBeClickable(recoverButton);
		ElementUtils.clickElement(driver, recoverButton);
		waitUtil.waitUpToElementToBeVisible(validationSummaryMessage);
		return ElementUtils.getText(driver, validationSummaryMessage);	
	}
	
	public String recoverPasswordWithInvalidEmail(String invalidEmail)
	{
		waitUtil.waitUpToElementToBeClickable(emailField);
		ElementUtils.enterText(driver, emailField, invalidEmail);
		waitUtil.waitUpToElementToBeClickable(recoverButton);
		ElementUtils.clickElement(driver, recoverButton);
		waitUtil.waitUpToElementToBeVisible(validationSummaryMessage);
		return ElementUtils.getText(driver, validationSummaryMessage);	
	}
	
	public String recoverPasswordWithUnregisteredEmail(String wrongEmail)
	{
		waitUtil.waitUpToElementToBeClickable(emailField);
		ElementUtils.enterText(driver, emailField, wrongEmail);
		waitUtil.waitUpToElementToBeClickable(recoverButton);
		ElementUtils.clickElement(driver, recoverButton);
		waitUtil.waitUpToElementToBeVisible(resultMessage);
		return ElementUtils.getText(driver, resultMessage);	
	}
	
}
