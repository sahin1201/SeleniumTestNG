package com.automation.tests;

import com.TestBase;
import com.automation.pages.BuyProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_03_BuyProduct extends TestBase {

    @BeforeMethod
    public void setUp() {
        buyProductPage = new BuyProductPage();
    }

    @Test(priority = 1)
    public void buyProductTest() {
        extentLogger = extent.createTest("User should be able to successfully buy product");
        buyProductPage.enterEmailId("vdivya@imageboard4free.com");
        buyProductPage.enterPassword("123456");
        extentLogger.info("User writes registered email and password");
        buyProductPage.clickOnSubmitButton();
        extentLogger.info("User click on sign in button");
        buyProductPage.clickOnWomenButton();
        extentLogger.info("User click on Women module");
        buyProductPage.clickOnBlouse();
        extentLogger.info("User click on Blouse product");
        buyProductPage.clickOnAddToCartButton();
        extentLogger.info("User click on add to cart button");
        buyProductPage.clickProceedToCheckoutButton();
        extentLogger.info("User click on proceed to checkout button");
        buyProductPage.clickOnNextStepProceedToCheckoutButton();
        extentLogger.info("User click on proceed to checkout button");
        buyProductPage.selectPaymentButton("bank");
        extentLogger.info("User chooses bank method for payment");
        buyProductPage.clickOnIConfirmMyOrderButton();
        extentLogger.info("User click on I confirm my order button");
        buyProductPage.verifyOrderConfirmationPage();
        extentLogger.info("User successfully verify order");

        extentLogger.pass("Test is pass");


    }

    @Test(priority = 2)
    public void agreeTermsError() {
        extentLogger = extent.createTest("If user does not sign agreement terms of service");
        buyProductPage.agreeTermsError();
        extentLogger.info("user wants to buy blouse product but not click on agree to the terms of service");
        String actualMessage = buyProductPage.agreeTermsError.getText();
        String expectedMessage = "You must agree to the terms of service before continuing.";
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.info("Verify user failed buy product");

        extentLogger.pass("Test is pass");

    }

}
