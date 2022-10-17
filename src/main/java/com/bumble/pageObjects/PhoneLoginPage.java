package com.bumble.pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * This class contains mobile elements and actions to perform on phone login screen
 *
 * @developer: Abdul Sathar Beigh
 */
public class PhoneLoginPage extends BasePage {

    @FindBy(id="reg_input_edittext")
    WebElement phoneNumberInput;

    @FindBy(id="registration_prefix")
    WebElement countryCodeSelector;

    @FindBy(id="reg_footer_button")
    WebElement nextButton;

    @FindBy(id="navbar_search")
    WebElement searchInput;

    @FindBy(id="rightItem")
    WebElement countryCode;

    @FindBy(xpath = "//*[@text='Please check your number']")
    WebElement errorMessage;

    public PhoneLoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void enterPhoneNumber(String country, String phoneNumber){
        countryCodeSelector.click();
        searchCountryCode(country);
        phoneNumberInput.sendKeys(phoneNumber);
        hideKeyboard();
    }

    public void clickNext() {
        nextButton.click();
    }

    public void verifyErrorMessage() {
        //waitForVisibility(errorMessage);
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    public void searchCountryCode(String country) {

        searchInput.sendKeys(country);
        clickOn(countryCode);
    }
}
