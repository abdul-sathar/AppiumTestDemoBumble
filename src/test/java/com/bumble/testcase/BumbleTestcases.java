package com.bumble.testcase;

import com.bumble.dataprovider.TestDataProvider;
import com.bumble.pageObjects.FacebookLoginPage;
import com.bumble.pageObjects.PhoneLoginPage;
import org.testng.annotations.Test;

/**
 * This class contains testcases for bumble app
 *
 * @Developer: Abdul Sathar Beigh
 */
public class BumbleTestcases extends BaseTest {

    @Test(description = "This test is to verify bumble app landing page")
    public void testLandingPage() {
        landingPage.verifyLandingScreen();
    }

    @Test(dataProvider = "testdata", dataProviderClass = TestDataProvider.class, description = " This test is to verify phone login with invalid phone number")
    public void testLoginWithInvalidPhoneNumber(String country, String invalidNPhoneNumber) {
        PhoneLoginPage phoneLoginPage = landingPage.clickManualLoginButton();
        phoneLoginPage.enterPhoneNumber(country,invalidNPhoneNumber);
        phoneLoginPage.clickNext();
        phoneLoginPage.verifyErrorMessage();
    }

    @Test(description = " This test is to verify the integration between bumble app and facebook login page ")
    public void testTheFacebookLoginPage() {
        FacebookLoginPage facebookLoginPage = landingPage.clickFacebookLoginButton();
        facebookLoginPage.verifyFacebookLoginPage();
    }

}
