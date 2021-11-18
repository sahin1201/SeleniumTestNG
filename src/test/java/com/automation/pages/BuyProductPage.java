package com.automation.pages;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BuyProductPage extends BasePage {

    @FindBy(css = "input#email")
    public WebElement emailID;

    @FindBy(css = "input#passwd")
    public WebElement inputPassword;

    @FindBy(css = "button#SubmitLogin")
    public WebElement submitButton;

    @FindBy(xpath = "(//a[contains(text(),'Women')])[1]")
    public WebElement womenButton;

    @FindBy(xpath = "//img[@title='Blouse']")
    public WebElement blouse;

    @FindBy(css = "p#add_to_cart button[type='submit']")
    public WebElement addCartButton;

    @FindBy(css = "div.button-container a[title='Proceed to checkout']")
    public WebElement proceedToCheckoutButton;

    @FindBy(css = "p.cart_navigation.clearfix a[title='Proceed to checkout']")
    public WebElement stepNextProceedToCheckButton;

    @FindBy(css = "form[method='post'] button[name='processAddress']")
    public WebElement addressProceedToCheckButton;

    @FindBy(css = "div.checker input[type='checkbox']")
    public WebElement inputAgree;

    @FindBy(css = "form[method='post'] button[name='processCarrier']")
    public WebElement shippingProceedToCheckButton;

    @FindBy(css = "div#HOOK_PAYMENT p.payment_module a.bankwire")
    public WebElement payByBankWire;

    @FindBy(css = "div#HOOK_PAYMENT p.payment_module a.cheque")
    public WebElement payByCheck;

    @FindBy(css = "p#cart_navigation button[type='submit']")
    public WebElement iConfirmMyOrder;

    @FindBy(css = "div#center_column")
    public WebElement orderConfirmationPage;

    /*
    Negative locate element
     */

    @FindBy(xpath = "//p[@class='fancybox-error']")
    public WebElement agreeTermsError;


    /**
     * User write email and password. And then all the following method uses successfully buy product
     *
     * @param signInEmail
     */

    public void enterEmailId(String signInEmail) {
        emailID.sendKeys(signInEmail);
    }

    public void enterPassword(String SignInPass) {
        inputPassword.sendKeys(SignInPass);

    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void clickOnWomenButton() {
        womenButton.click();

    }

    public void clickOnBlouse() {
        blouse.click();

    }

    public void clickOnAddToCartButton() {

        Driver.get().switchTo().frame(0);
        addCartButton.click();
        Driver.get().switchTo().parentFrame();


    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public void clickOnNextStepProceedToCheckoutButton() {
        stepNextProceedToCheckButton.click();
        addressProceedToCheckButton.click();
        inputAgree.click();
        shippingProceedToCheckButton.click();
    }

    public void selectPaymentButton(String payment) {
        if (payment.equals("bank")) {
            payByBankWire.click();
        } else {
            payByCheck.click();
        }
    }

    public void clickOnIConfirmMyOrderButton() {

        iConfirmMyOrder.click();

    }

    public void verifyOrderConfirmationPage() {
        Assert.assertTrue(orderConfirmationPage.isDisplayed(), "Your order has been done successfully ");
    }

    /**
     * User does not sign the agreement terms
     */

    public void agreeTermsError() {
        String userEmail = ConfigurationReader.get("userEmailAgreeTerms");
        String userPass = ConfigurationReader.get("userPassAgreeTerms");
        emailID.sendKeys(userEmail);
        inputPassword.sendKeys(userPass);
        clickOnSubmitButton();
        clickOnWomenButton();
        clickOnBlouse();
        clickOnAddToCartButton();
        clickProceedToCheckoutButton();
        stepNextProceedToCheckButton.click();
        addressProceedToCheckButton.click();
        shippingProceedToCheckButton.click();

    }


}

