package com.bumble.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

/**
 * This class contains mobile elements and actions to perform on bumble landing screen
 *
 * @developer: Abdul Sathar Beigh
 */
public class LandingPage extends BasePage {
    @FindBy(id = "landing_logo")
    @CacheLookup
    WebElement companyLogo;
    @FindBy(id = "first_moves_text")
    @CacheLookup
    WebElement companySlogan;
    @FindBy(id = "landing_facebookLoginButton")
    @CacheLookup
    WebElement facebookLoginButton;
    @FindBy(id = "landing_manualLoginButton")
    @CacheLookup
    WebElement manualLoginButton;
    @FindBy(id = "landing_termsAndConditions")
    @CacheLookup
    WebElement termsAndConditions;

    public LandingPage(AppiumDriver driver) {
        super(driver);
    }

    public void verifyLandingScreen(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(companyLogo.isDisplayed(),"Company logo is not displayed");
        softAssert.assertTrue(companySlogan.isDisplayed(),"Company slogan is not displayed");
        softAssert.assertTrue(facebookLoginButton.isDisplayed(),"Facebook login button is not displayed");
        softAssert.assertTrue(manualLoginButton.isDisplayed(), "Use cell phone button is not displayed");
        softAssert.assertTrue(termsAndConditions.isDisplayed(),"Terms and Conditions is not displayed");
        softAssert.assertAll();
    }

    public FacebookLoginPage clickFacebookLoginButton(){
        try {
            clickOn(facebookLoginButton);
            return new FacebookLoginPage(driver);
        } catch (Exception e) {
            throw new RuntimeException("Unable to click on Facebook login button");
        }
    }

    public PhoneLoginPage clickManualLoginButton(){
       try {
           clickOn(manualLoginButton);
           return new PhoneLoginPage(driver);
       } catch (Exception e) {
           throw new RuntimeException("Unable to click on Use cell Phone Number button");
       }
    }
}
