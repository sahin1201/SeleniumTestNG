package com.automation.tests;

import com.TestBase;
import com.automation.pages.BuyProductPage;
import com.automation.pages.SignInPage;
import com.automation.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_02_NegativeSignIn extends TestBase {

    @BeforeMethod
    public void setUp() {
        buyProductPage = new BuyProductPage();
        signInPage = new SignInPage();
    }

  // BuyProductPage buyProductPage = new BuyProductPage();

    @Test(priority = 1)
    public void authenticationError() {
        extentLogger = extent.createTest("User should gets authentication error on sign in page");
        email = BrowserUtils.generateEmail();
        buyProductPage.enterEmailId(email);
        extentLogger.info("User writes unregistered random email");
        buyProductPage.enterPassword("00000");
        extentLogger.info("User writes incorrect password");
        buyProductPage.clickOnSubmitButton();
        String actualMessage = signInPage.signInPassError.getText();
        String expectedMessage = "Authentication failed.";
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.info("Verify user failed sign in with wrong email");

        extentLogger.pass("Test is pass");

    }

    @Test(priority = 2)
    public void failedPasswordError() {
        extentLogger = extent.createTest("User should gets invalid password on sign in page");
        signInPage.incorrectSignIn();
        extentLogger.info("User writes registered email but wrong pass and click on sign in button");
        String actualMessage = signInPage.invalidPasswordError.getText();
        String expectedMessage = "Invalid password.";
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.info("Verify user failed sign in" + expectedMessage);

        extentLogger.pass("Test is pass");
    }
}
