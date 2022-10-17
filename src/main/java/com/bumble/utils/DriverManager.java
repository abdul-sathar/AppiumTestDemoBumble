package com.bumble.utils;

import com.bumble.pageObjects.LandingPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class DriverManager {

    /**
     * This method generate driver for Android platform
     *
     * @param deviceName Name of device
     * @param port Port number on which Appium server runs
     * @return Android driver
     *
     * @developer: Abdul Sathar Beigh
     */
    public static AndroidDriver setAndroidDriver(String deviceName, String port)
    {
        DesiredCapabilities caps = null;
        try {
            caps = DesireCapabilitiesManager.getDesiredCapabilities(deviceName, "/config/capabilities.json");
            return new AndroidDriver(new URL("http://localhost:"+port+"/wd/hub"),caps);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
