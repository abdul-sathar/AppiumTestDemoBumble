package com.bumble.testcase;

import com.bumble.pageObjects.LandingPage;
import com.bumble.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.time.Duration;

/**
 * This class contains test configuration methods
 * @Developer: Abdul Sathar Beigh
 */
public class BaseTest {
    public ThreadLocal<AppiumDriver> driver= new ThreadLocal<>();
    public LandingPage landingPage;

    public void setDriver(AppiumDriver driver){
        this.driver.set(driver);
    }

    public AppiumDriver getDriver(){
        return this.driver.get();
    }

    @BeforeMethod
    @Parameters({"deviceName","port"})
    public void setDriver(String deviceName, String port) throws Exception {
        setDriver(DriverManager.setAndroidDriver(deviceName,port));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        landingPage=new LandingPage(getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver()
    {
        getDriver().quit();
    }

    public void startAppiumService(String port)
    {
        AppiumDriverLocalService service;
        AppiumServiceBuilder builder= new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1")
                .usingPort(Integer.parseInt(port))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        service= builder.build();
        service.start();
        System.out.println("Service has been started with port number: "+port);
    }

    public void stopServer() {
        String[] command = { "/usr/bin/killall", "-KILL", "node" };
        try {
            Runtime.getRuntime().exec(command);
            System.out.println("Appium server stopped.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
