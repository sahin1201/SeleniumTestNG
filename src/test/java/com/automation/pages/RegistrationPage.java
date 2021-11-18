package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(css = "a.login")
    public WebElement buttonSignIn;

    @FindBy(id = "email_create")
    public WebElement inputEmailForRegistration;

    @FindBy(id = "SubmitCreate")
    public WebElement buttonCreateAccount;

    /*
     *  Personal information elements
     */

    @FindBy(id = "id_gender1")
    public WebElement radioButtonMale;

    @FindBy(id = "customer_firstname")
    public WebElement inputFirstName;

    @FindBy(id = "customer_lastname")
    public WebElement inputLastName;

    @FindBy(id = "passwd")
    public WebElement inputPassword;

    /*
     *  Address data elements
     */

    @FindBy(id = "address1")
    public WebElement inputAddress;

    @FindBy(id = "city")
    public WebElement inputCity;

    @FindBy(xpath = "//span[contains(text(),'United States')]")
    public WebElement inputCountry;

    @FindBy(id = "id_state")
    public WebElement selectState;

    @FindBy(xpath = "//option[contains(text(),'Alabama')]")
    public WebElement inputState;

    @FindBy(id = "postcode")
    public WebElement inputPostcode;

    @FindBy(id = "phone_mobile")
    public WebElement inputMobilePhone;

    @FindBy(id = "alias")
    public WebElement inputAlias;

    @FindBy(id = "submitAccount")
    public WebElement buttonRegister;

    @FindBy(css = "p.info-account")
    public WebElement verifyMyAccount;

    /**
     * Negative locate elements
     */

    @FindBy(xpath = "//div[@class='columns-container']//li[1]")
    public WebElement phoneNumberError;

    @FindBy(xpath = "//div[@class='columns-container']//li[2]")
    public WebElement lastNameError;

    @FindBy(xpath = "//div[@class='columns-container']//li[3]")
    public WebElement firstNameError;

    @FindBy(xpath = "//div[@class='columns-container']//li[4]")
    public WebElement passwordError;

    @FindBy(xpath = "//div[@class='columns-container']//li[5]")
    public WebElement addressError;

    @FindBy(xpath = "//div[@class='columns-container']//li[6]")
    public WebElement cityError;

    @FindBy(xpath = "//li[contains(text(),\"The Zip/Postal code you've entered is invalid. It \")]")
    public WebElement postcodeError;

    @FindBy(xpath = "//li[contains(text(),'This country requires you to choose a State.')]")
    public WebElement stateError;

    @FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
    public WebElement signUpError;


    /**
     * User should be able to go registration page
     */

    public void goToRegistrationPage() {
        buttonSignIn.click();
    }

    /**
     * User generate email for sign up
     *
     * @param email
     */

    public void openRegistrationForm(String email) {
        inputEmailForRegistration.sendKeys(email);
        buttonCreateAccount.click();


    }

    /**
     * Then all of the following methods are used to sign up with parameters.
     */

    public void selectTitle() {

        BrowserUtils.selectCheckBox(radioButtonMale, true);
    }

    public void selectName() {

        String userName = ConfigurationReader.get("userName");
        String userLastName = ConfigurationReader.get("userLastName");
        inputFirstName.sendKeys(userName);
        inputLastName.sendKeys(userLastName);

    }

    public void enterPassword() {

        String userPassword = ConfigurationReader.get("userPassword");
        inputPassword.sendKeys(userPassword);

    }

    public void enterAddress() {
        String userAddress = ConfigurationReader.get("userAddress");
        inputAddress.sendKeys(userAddress);
    }

    public void enterCity() {
        String userCity = ConfigurationReader.get("userCity");
        inputCity.sendKeys(userCity);

    }

    public void selectState() {

        selectState.click();
        BrowserUtils.waitForVisibility(inputState, 5);
        inputState.click();
    }

    public void enterPostCode() {
        String postCode = ConfigurationReader.get("userPostCode");
        inputPostcode.sendKeys(postCode);

    }

    public void selectCountry() {

        BrowserUtils.waitForVisibility(inputCountry, 5);

    }

    public void phoneNumber() {

        String userPhoneNumber = ConfigurationReader.get("userPhoneNumber");
        inputMobilePhone.sendKeys(userPhoneNumber);

    }

    public void aliasForFutureReference() {
        String alias = ConfigurationReader.get("userAliasAddress");
        inputAlias.sendKeys(alias);
    }

    public void clickOnRegisterButton() {
        buttonRegister.click();
    }

    /**
     * User successful account creation verification
     */

    public void verifyAccountCreatedSuccessfully() {

        BrowserUtils.verifyElementDisplayed(verifyMyAccount);
    }

    /**
     * This method uses incorrect generate email for sign up
     */

    public void incorrectSignUp() {
        String userEmail = ConfigurationReader.get("createWrongEmail");
        inputEmailForRegistration.sendKeys(userEmail);
        buttonCreateAccount.click();

    }

}
