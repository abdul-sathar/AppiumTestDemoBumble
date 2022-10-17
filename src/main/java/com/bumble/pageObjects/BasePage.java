package com.bumble.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

/**
 * This class contains basic setup for page objects
 *
 * @developer: Abdul Sathar Beigh
 */
public class BasePage {

    AppiumDriver driver;
    public BasePage(AppiumDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    /**
     * This method dynamically wait for mobile element to be visible
     *
     * @param  element Mobile element
     *
     * @developer: Abdul Sathar Beigh
     */
    public void waitForVisibility(WebElement element){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method clicks on mobile element
     *
     * @param  element Mobile element
     *
     * @developer: Abdul Sathar Beigh
     */
    public void clickOn(WebElement element){
        waitForVisibility(element);
        element.click();
    }

    /**
     * This method switch app from native to web view
     *
     * @developer: Abdul Sathar Beigh
     */
    public void switchToWebView(){
        Set<String> contexts = ((AndroidDriver) driver).getContextHandles();
        for(String context: contexts){
            if(context.contains("WEBVIEW")) {
                ((AndroidDriver) driver).context(context);
                break;
            }
        }
    }

    /**
     * This method switch to Native app
     *
     * @developer: Abdul Sathar Beigh
     */
    public void switchToNative()
    {
        ((AndroidDriver) driver).context("NATIVE_APP");
    }

    /**
     * This method hides the keyboard on mobile device
     *
     * @developer: Abdul Sathar Beigh
     */
    public void hideKeyboard(){
        ((AndroidDriver) driver).hideKeyboard();
    }
}
