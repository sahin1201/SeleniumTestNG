package com.automation.tests;

import com.TestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01_UserRegistration extends TestBase {



    @Test(priority = 1)
    public void signUpTest() {
        extentLogger = extent.createTest("User should successfully sign up");
        email = BrowserUtils.generateEmail();
        extentLogger.info("User generate random email");
        registrationPage.openRegistrationForm(email);
        extentLogger.info("User generate an email and click Create an account button");

        BrowserUtils.waitFor(5);
        String actualUrl = Driver.get().getCurrentUrl();
        String expectedUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
        Assert.assertEquals(actualUrl, expectedUrl);
        extentLogger.info("verify that URL is : " + expectedUrl);

        registrationPage.selectTitle();
        extentLogger.info("User chooses gender type");
        registrationPage.selectName();
        extentLogger.info("User writes name and surname");
        registrationPage.enterPassword();
        extentLogger.info("User create a validate password");
        registrationPage.enterAddress();
        extentLogger.info("User writes home address");
        registrationPage.enterCity();
        extentLogger.info("User chooses city of residence");
        registrationPage.selectState();
        extentLogger.info("User chooses state of residence");
        registrationPage.enterPostCode();
        extentLogger.info("User writes postcode");
        registrationPage.selectCountry();
        extentLogger.info("User chooses country of residence");
        registrationPage.phoneNumber();
        extentLogger.info("User writes telephone number");
        registrationPage.aliasForFutureReference();
        extentLogger.info("User writes alias for address");
        registrationPage.clickOnRegisterButton();
        extentLogger.info("User click on register button");
        registrationPage.verifyAccountCreatedSuccessfully();
        extentLogger.info("User verify create an account");

        extentLogger.pass("Test is pass");

    }

    @Test(priority = 2)
    public void inCorrectSignUp() {
        extentLogger = extent.createTest("User gets Invalid email address error");
        registrationPage.incorrectSignUp();
        extentLogger.info("User writes incorrect email and click on Create an account button");
        String actualMessage = registrationPage.signUpError.getText();
        String expectedMessage = "Invalid email address.";
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.info("Verify user failed sign up");

        extentLogger.pass("Test is pass");
    }

    @Test(priority = 3)
    public void requiredFieldsWarning() {
        extentLogger = extent.createTest("User gets required fields warning on register page");
        email = BrowserUtils.generateEmail();
        System.out.println("email =" + email);
        registrationPage.openRegistrationForm(email);
        extentLogger.info("user writes generated email and click on Create an account button");
        registrationPage.clickOnRegisterButton();
        extentLogger.info("user click on Register button");
        wait.until(ExpectedConditions.visibilityOf(registrationPage.phoneNumberError));
        extentLogger.info("calling until method from wait phone number error");
        wait.until(ExpectedConditions.visibilityOf(registrationPage.lastNameError));
        extentLogger.info("calling until method from wait last name error");
        wait.until(ExpectedConditions.visibilityOf(registrationPage.firstNameError));
        extentLogger.info("calling until method from wait first name error");
        wait.until(ExpectedConditions.visibilityOf(registrationPage.passwordError));
        extentLogger.info("calling until method from wait password error");
        wait.until(ExpectedConditions.visibilityOf(registrationPage.addressError));
        extentLogger.info("calling until method from wait address error");
        wait.until(ExpectedConditions.visibilityOf(registrationPage.cityError));
        extentLogger.info("calling until method from wait city error");
        wait.until(ExpectedConditions.visibilityOf(registrationPage.postcodeError));
        extentLogger.info("calling until method from wait post code error");
       //wait.until(ExpectedConditions.visibilityOf(registrationPage.stateError));
        BrowserUtils.verifyElementDisplayed(registrationPage.stateError);
        extentLogger.info("calling until method from wait state error");

        extentLogger.pass("Test is pass");

    }





}

