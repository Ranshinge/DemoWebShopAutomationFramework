package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demowebshop.config.ConfigReader;
import com.demowebshop.utils.ElementUtils;

public class HomePage extends BasePage
{
	//Locators
	
	private By registerLink = By.xpath("//a[@href='/register']");
	private By logo = By.cssSelector("img[alt='Tricentis Demo Web Shop']");
	private By loginLink = By.xpath("//a[normalize-space()='Log in']");
	// Logged-in User Locators
	private By registeredUserEmail = By.xpath("//div[@class='header-links']//a[@class='account']");
	private By logoutLink = By.xpath("//a[@href='/logout']");

	public HomePage(WebDriver driver) 
	{
        super(driver);
    }
	
	public boolean isRegisterLinkDisplayed()
	{
		return ElementUtils.isElementDisplayed(driver, registerLink);
	}
	
	public String getPageTitle()
	{
		String title = ElementUtils.getTitle(driver);
		return title;
	}
	
	public boolean verifyPageTitle()
	{
		String expectedTitle = ConfigReader.getProperty("Title");
		return expectedTitle.equals(getPageTitle());
	}
	
	public boolean isLogoDisplayed()
	{
		return ElementUtils.isElementDisplayed(driver, logo);
	}
	
	public boolean isLoginLinkDisplayed()
	{
		return ElementUtils.isElementDisplayed(driver, loginLink);
	}
	
	public void openRegisterPage()
	{
		ElementUtils.clickElement(driver, registerLink);
	}
	
	public void openLoginPage()
	{
		ElementUtils.clickElement(driver, loginLink);
	}

	public String getRegisteredUserEmail() {
	    return ElementUtils.getText(driver, registeredUserEmail);
	}

	public boolean isLogoutLinkDisplayed() {
	    return ElementUtils.isElementDisplayed(driver, logoutLink);
	}
}
