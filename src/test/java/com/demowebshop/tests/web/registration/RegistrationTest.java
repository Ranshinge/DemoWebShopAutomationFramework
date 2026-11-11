package com.demowebshop.tests.web.registration;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegistrationPage;
import com.demowebshop.tests.base.BaseTest;
import com.demowebshop.tests.dataproviders.RegistrationDataProvider;
import com.demowebshop.driver.DriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationTest extends BaseTest {

    private HomePage homePage;
    private RegistrationPage registrationPage;

    private static final Logger logger =
            LogManager.getLogger(RegistrationTest.class);

    @BeforeClass
    public void initializePages() {

        logger.info("Initializing Page Objects");

        homePage = new HomePage(DriverFactory.getDriver());
        registrationPage = new RegistrationPage(DriverFactory.getDriver());

        logger.info("Page Objects initialized successfully");
    }

    // REG_001
    @Test
    public void verifyRegistrationPage() {

        logger.info("Starting Registration Page Test");

        logger.info("Opening Registration Page");
        homePage.openRegisterPage();

        logger.info("Registration Page opened successfully");

        logger.info("Verifying Page Title");
        Assert.assertTrue(
                registrationPage.verifyPageTitle(),
                "Registration page title does not match!"
        );

        logger.info("Registration Page title verified successfully");
    }

    // REG_002
    @Test(dataProvider = "genderData",
          dataProviderClass = RegistrationDataProvider.class)
    public void verifyGenderSelection(String gender) {

        final SoftAssert softassert = new SoftAssert();

        logger.info("Starting Gender Selection Test for: {}", gender);

        logger.info("Opening Registration Page");
        homePage.openRegisterPage();

        logger.info("Selecting gender: {}", gender);
        registrationPage.selectGender(gender);

        logger.info("Verifying gender selection: {}", gender);
        softassert.assertTrue(
                registrationPage.isGenderSelected(gender),
                gender + " radio button is not selected!"
        );

        softassert.assertAll();

        logger.info("Gender selected successfully: {}", gender);
    }

    // REG_003
    @Test(dataProvider = "validRegistrationData",
          dataProviderClass = RegistrationDataProvider.class)
    public void verifyValidRegistration(
            String gender,
            String firstName,
            String lastName,
            String email,
            String password,
            String confirmPassword) {

        final SoftAssert softassert = new SoftAssert();

        logger.info("Starting Valid Registration Test");

        logger.info("Opening Registration Page");
        homePage.openRegisterPage();

        logger.info("Selecting gender: {}", gender);
        registrationPage.selectGender(gender);

        logger.info("Entering registration details");

        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(confirmPassword);

        logger.info("Submitting registration form");
        registrationPage.registerUser();

        logger.info("Retrieving registration success message");
        String actualMessage = registrationPage.getRegistrationSuccessMessage();

        softassert.assertTrue(
                actualMessage.contains("Your registration completed"),
                "Registration was not successful!"
        );

        logger.info("Verifying Continue button");
        softassert.assertTrue(
                registrationPage.isContinueButtonDisplayed(),
                "Continue button is not displayed!"
        );

        softassert.assertAll();

        logger.info("Registration completed successfully");

        registrationPage.clickContinueButton();

        logger.info("Continue button clicked successfully");
    }

    // REG_004
    @Test(dataProvider = "invalidregistrationData",
          dataProviderClass = RegistrationDataProvider.class)
    public void verifyInvalidRegistration(
            String gender,
            String firstName,
            String lastName,
            String email,
            String password,
            String confirmPassword) {

        final SoftAssert softassert = new SoftAssert();

        logger.info("Starting Invalid Registration Test");

        logger.info("Opening Registration Page");
        homePage.openRegisterPage();

        logger.info("Entering invalid registration details");

        registrationPage.selectGender(gender);
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(confirmPassword);

        logger.info("Submitting invalid registration form");
        registrationPage.registerUser();

        logger.info("Verifying First Name validation");
        String firstNameErrorMessage = registrationPage.getFirstNameError();

        softassert.assertTrue(
                firstNameErrorMessage.contains("First name is required."),
                "First Name validation failed!"
        );

        logger.info("Verifying Last Name validation");
        String lastNameErrorMessage = registrationPage.getLastNameError();

        softassert.assertTrue(
                lastNameErrorMessage.contains("Last name is required."),
                "Last Name validation failed!"
        );

        logger.info("Verifying Email validation");
        String emailErrorMessage = registrationPage.getEmailError();

        softassert.assertTrue(
                emailErrorMessage.contains("Wrong email"),
                "Email validation failed!"
        );

        logger.info("Verifying Password validation");
        String passwordErrorMessage = registrationPage.getPasswordError();

        softassert.assertTrue(
                passwordErrorMessage.contains(
                        "The password should have at least 6 characters."
                ),
                "Password validation failed!"
        );

        logger.info("Verifying Confirm Password validation");
        String confirmPasswordErrorMessage =
                registrationPage.getConfirmPasswordError();

        softassert.assertTrue(
                confirmPasswordErrorMessage.contains(
                        "The password and confirmation password do not match."
                ),
                "Confirm password validation failed!"
        );

        softassert.assertAll();

        logger.info("All invalid registration validations verified successfully");
    }

    // REG_005
    @Test(dataProvider = "alreadyRegisteredEmailData",
          dataProviderClass = RegistrationDataProvider.class)
    public void verifyAlreadyRegisteredEmailValidation(
            String gender,
            String firstName,
            String lastName,
            String email,
            String password,
            String confirmPassword) {

        final SoftAssert softassert = new SoftAssert();

        logger.info("Starting Already Registered Email Validation Test");

        logger.info("Opening Registration Page");
        homePage.openRegisterPage();

        logger.info("Entering registration details with existing email");

        registrationPage.selectGender(gender);
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(confirmPassword);

        logger.info("Submitting registration form");
        registrationPage.registerUser();

        logger.info("Verifying already registered email validation");

        String alreadyRegisteredEmailValidationMessage =
                registrationPage.getAlreadyRegisteredEmailMessage();

        softassert.assertTrue(
                alreadyRegisteredEmailValidationMessage.contains(
                        "The specified email already exists"
                ),
                "Already registered email validation failed!"
        );

        softassert.assertAll();

        logger.info("Already registered email validation verified successfully");
    }
}