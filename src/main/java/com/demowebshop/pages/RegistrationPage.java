package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demowebshop.config.ConfigReader;
import com.demowebshop.utils.ElementUtils;
import com.demowebshop.utils.SelectionUtils;
import com.demowebshop.utils.WaitUtils;

public class RegistrationPage extends BasePage {
	
	//Locators 
	private By maleRadioButton = By.xpath("//input[@id='gender-male']");
	private By femaleRadioButton = By.xpath("//input[@id='gender-female']");
	private By firstNameInput = By.xpath("//input[@id='FirstName']");
	private By lastNameInput = By.xpath("//input[@id='LastName']");
	private By emailInput = By.cssSelector("#Email");
	private By passwordInput = By.xpath("//input[@id='Password']");
	private By confirmPasswordInput = By.xpath("//input[@id='ConfirmPassword']");
	private By registerButton = By.xpath("//input[@id='register-button']");
	private By firstNameError = By.xpath("//span[@for='FirstName']");
	private By lastNameError = By.xpath("//span[@for='LastName']");
	private By emailError = By.xpath("//span[@for='Email']");
	private By passwordError = By.xpath("//span[@for='Password']");
	private By confirmPasswordError = By.xpath("//span[@for='ConfirmPassword']");
	private By confirmRegisterTextMessage = By.xpath("//div[@class='page registration-result-page']");
	private By continueButton = By.xpath("//input[@value='Continue']");
	private By alreadyRegisteredEmailMessage = By.xpath("//li[normalize-space()='The specified email already exists']");
	
	private WaitUtils waitUtils;
	
	public RegistrationPage(WebDriver driver) 
	{
        super(driver);
        waitUtils = new WaitUtils(driver);
    }
	
	public String getPageTitle()
	{
		String title = ElementUtils.getTitle(driver);
		return title;
	}
	
	public boolean verifyPageTitle()
	{
		String expectedTitle = ConfigReader.getProperty("registerTitle");
		return expectedTitle.equals(getPageTitle());
	}
	
	public void selectGender(String gender) {

	    if (gender == null) {
	        throw new IllegalArgumentException("Gender cannot be null");
	    }

	    if (gender.equalsIgnoreCase("Male")) {
	    	
	    	
	    	waitUtils.waitUpToElementToBeVisible(maleRadioButton);
	        SelectionUtils.selectRadioButton(driver, maleRadioButton);
	    } else if (gender.equalsIgnoreCase("Female")) {
	    	waitUtils.waitUpToElementToBeVisible(femaleRadioButton);
	        SelectionUtils.selectRadioButton(driver, femaleRadioButton);
	    } else {

	        throw new IllegalArgumentException("Invalid gender: " + gender);
	    }
	    
	}
	
	public boolean isGenderSelected(String gender) {

	    if (gender.equalsIgnoreCase("Male")) {
	        return driver.findElement(maleRadioButton).isSelected();
	    }
	    else if (gender.equalsIgnoreCase("Female")) {
	        return driver.findElement(femaleRadioButton).isSelected();
	    }
	    else {
	        throw new IllegalArgumentException("Invalid gender: " + gender);
	    }
	}
	
	public void enterFirstName(String firstName)
	{
		ElementUtils.enterText(driver, firstNameInput, firstName);
	}
	
	public void enterLastName(String lastName)
	{
		ElementUtils.enterText(driver, lastNameInput, lastName);
	}
	
	public void enterEmail(String email)
	{
		ElementUtils.enterText(driver, emailInput, email);
	}
	
	public void enterPassword(String password)
	{
		ElementUtils.enterText(driver, passwordInput, password);
	}
	public void enterConfirmPassword(String confirmPassword)
	{
		ElementUtils.enterText(driver, confirmPasswordInput, confirmPassword);
	}
	
	public void registerUser()
	{
		ElementUtils.clickElement(driver, registerButton);
	}
	
	public String getValidationMessage(By locator)
	{
		waitUtils.waitUpToElementToBeVisible(locator);
	    return ElementUtils.getText(driver, locator);
	}
	
	public String getFirstNameError() 
	{
	    return getValidationMessage(firstNameError);
	}
	
	public String getLastNameError() 
	{
	    return getValidationMessage(lastNameError);
	}
	
	public String getEmailError() 
	{
	    return getValidationMessage(emailError);
	}
	
	public String getPasswordError() 
	{
	    return getValidationMessage(passwordError);
	}
	
	public String getConfirmPasswordError() 
	{
	    return getValidationMessage(confirmPasswordError);
	}
	
	public String getRegistrationSuccessMessage()
	{
		waitUtils.waitUpToElementToBeVisible(confirmRegisterTextMessage);
		return ElementUtils.getText(driver, confirmRegisterTextMessage);
	}
	public String getAlreadyRegisteredEmailMessage()
	{
		waitUtils.waitUpToElementToBeVisible(alreadyRegisteredEmailMessage);
		return ElementUtils.getText(driver, alreadyRegisteredEmailMessage);
	}
	public boolean isContinueButtonDisplayed() 
	{
		waitUtils.waitUpToElementToBeVisible(continueButton);
	    return ElementUtils.isElementDisplayed(driver, continueButton);
	}
	
	public void clickContinueButton() 
	{
		waitUtils.waitUpToElementToBeVisible(continueButton);
	    ElementUtils.clickElement(driver, continueButton);
	}
}
