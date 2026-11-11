package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demowebshop.utils.ElementUtils;
import com.demowebshop.utils.SelectionUtils;
import com.demowebshop.utils.WaitUtils;

public class LoginPage extends BasePage {

    // ==================== Locators ====================

    private By emailInputField = By.id("Email");
    private By passwordInputField = By.id("Password");

    private By rememberMeCheckbox = By.id("RememberMe");

    private By forgotPasswordLink = By.xpath("//a[normalize-space()='Forgot password?']");

    private By loginButton = By.xpath("//input[@value='Log in']");

    // Validation Messages
    private By validationSummaryMessage = By.xpath("//div[@class='validation-summary-errors']");

    private By invalidEmailErrorMessage = By.xpath("//span[@for='Email']");


    // ==================== Constructor ====================

    private WaitUtils waitUtils;

    public LoginPage(WebDriver driver) 
    {
        super(driver);
        this.waitUtils = new WaitUtils(driver);
    }


    // ==================== Login Actions ====================

    public void loginWithValidCredentials(String validEmail, String validPassword, boolean rememberMe) 
    {

        waitUtils.waitUpToElementToBeClickable(emailInputField);
        ElementUtils.enterText(driver, emailInputField, validEmail);

        waitUtils.waitUpToElementToBeClickable(passwordInputField);
        ElementUtils.enterText(driver, passwordInputField, validPassword);

        if (rememberMe) 
        {
            SelectionUtils.selectCheckbox(driver, rememberMeCheckbox);
        }

        waitUtils.waitUpToElementToBeClickable(loginButton);
        ElementUtils.clickElement(driver, loginButton);
    }


    public String loginWithInvalidCredentials(String invalidEmail, String invalidPassword) 
    {

        waitUtils.waitUpToElementToBeClickable(emailInputField);
        ElementUtils.enterText(driver, emailInputField, invalidEmail);

        waitUtils.waitUpToElementToBeClickable(passwordInputField);
        ElementUtils.enterText(driver, passwordInputField, invalidPassword);

        waitUtils.waitUpToElementToBeClickable(loginButton);
        ElementUtils.clickElement(driver, loginButton);

        waitUtils.waitUpToElementToBeVisible(validationSummaryMessage);

        return ElementUtils.getText(driver, validationSummaryMessage);
    }


    public String loginWithInvalidPassword(String validEmail, String invalidPassword) 
    {

        waitUtils.waitUpToElementToBeClickable(emailInputField);
        ElementUtils.enterText(driver, emailInputField, validEmail);

        waitUtils.waitUpToElementToBeClickable(passwordInputField);
        ElementUtils.enterText(driver, passwordInputField, invalidPassword);

        waitUtils.waitUpToElementToBeClickable(loginButton);
        ElementUtils.clickElement(driver, loginButton);

        waitUtils.waitUpToElementToBeVisible(validationSummaryMessage);

        return ElementUtils.getText(driver, validationSummaryMessage);
    }


    public String verifyInvalidEmailError(String invalidEmail) 
    {

        waitUtils.waitUpToElementToBeClickable(emailInputField);
        ElementUtils.enterText(driver, emailInputField, invalidEmail);

        waitUtils.waitUpToElementToBeClickable(loginButton);
        ElementUtils.clickElement(driver, loginButton);

        waitUtils.waitUpToElementToBeVisible(invalidEmailErrorMessage);

        return ElementUtils.getText(driver, invalidEmailErrorMessage);
    }

    public String loginWithEmptyCredentials() 
    {

        waitUtils.waitUpToElementToBeClickable(loginButton);

        ElementUtils.clickElement(driver, loginButton);

        waitUtils.waitUpToElementToBeVisible(validationSummaryMessage);

        return ElementUtils.getText(driver, validationSummaryMessage);
    }
    
    // ==================== Forgot Password Navigation ====================

    public void clickForgotPasswordLink() 
    {

        waitUtils.waitUpToElementToBeClickable(forgotPasswordLink);
        ElementUtils.clickElement(driver, forgotPasswordLink);
    }
}