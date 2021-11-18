package com.automation.pages;

import com.automation.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    public WebElement signInPassError;

    @FindBy(xpath = "//li[contains(text(),'Invalid password.')]")
    public WebElement invalidPasswordError;

    BuyProductPage buyProductPage = new BuyProductPage();


    /**
     * This method uses failed login with wrong password
     */

    public void incorrectSignIn() {
        String userEmail = ConfigurationReader.get("userEmail");
        String userWrongPass = ConfigurationReader.get("userWrongPass");
        buyProductPage.emailID.sendKeys(userEmail);
        buyProductPage.inputPassword.sendKeys(userWrongPass);
        buyProductPage.submitButton.click();

    }

}
