package com.bumble.pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * This class contains mobile elements and actions to perform on facebook login screen
 *
 * @developer: Abdul Sathar Beigh
 */
public class FacebookLoginPage extends BasePage{

    @FindBy(id="m_login_email")
    @CacheLookup
    WebElement userNameField;
    @FindBy(id="m_login_password")
    @CacheLookup
    WebElement passwordField;
    @FindBy(name="login")
    @CacheLookup
    WebElement loginButton;
    @FindBy(xpath="//*[@text='facebook']")
    WebElement facebookHeader;
    @FindBy(id="login_error")
    @CacheLookup
    WebElement loginErrorMessage;
    public FacebookLoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void verifyFacebookLoginPage() {
        waitForVisibility(facebookHeader);
        Assert.assertTrue(facebookHeader.isDisplayed(),"Couldn't verify facebook login page");
    }

    public void facebookLogin(String email, String password){
        waitForVisibility(facebookHeader);
        switchToWebView();
        userNameField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void verifyLoginErrorMessage() {
        waitForVisibility(loginErrorMessage);
        Assert.assertTrue(loginErrorMessage.isDisplayed());
    }
}
