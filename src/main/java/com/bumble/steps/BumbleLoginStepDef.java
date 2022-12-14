package com.bumble.steps;

import com.bumble.pageObjects.LandingPage;
import com.bumble.pageObjects.PhoneLoginPage;
import com.bumble.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

/**
 * This class contains step definitions for cucumber steps
 *
 * @developer: Abdul Sathar Beigh
 */
public class BumbleLoginStepDef {
    private AppiumDriver driver;
    private LandingPage landingPage;
    private PhoneLoginPage phoneLoginPage;
    @Given(": App is launched with device {string} and port {string}")
    public void appIsLaunchedWithDeviceAndPort(String deviceName, String port) {
        driver= DriverManager.setAndroidDriver(deviceName,port);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        landingPage=new LandingPage(driver);
    }

    @Then(": Verify bumble landing page")
    public void verifyBumbleLandingPage() {
        landingPage.verifyLandingScreen();
    }

    @Given(": Click use phone number button")
    public void clickUsePhoneNumberButton() {
        phoneLoginPage= landingPage.clickManualLoginButton();
    }

    @Then(": Verify Error message")
    public void verifyErrorMessage() {
        phoneLoginPage.verifyErrorMessage();

    }

    @When(": Select country {string} and enter {string}")
    public void selectCountryAndEnter(String country, String phoneNumber) {
        phoneLoginPage.enterPhoneNumber(country,phoneNumber);
    }

    @Then(": Click Next button")
    public void clickNextButton() {
        phoneLoginPage.clickNext();
    }

    @Then(": Close App")
    public void closeApp() {
        driver.quit();
    }
}
