# Mobile Automation Framework for Bumble App
This Test Automation framework is developed to automate tests that cover basic functionality for Bumble App for demo purpose.
Note: This framework (for interview demo purpose) currently run tests on Android platform and has capability to extent to iOS platform as well

Framework is designed using following Tech Stack: 
1. ***Java*** as language, 
2. ***Maven*** as build management tool,
3. ***Appium*** as mobile automation tool for both Android and iOS platform, 
4. ***TestNG*** as Unit Testing Framework, 
5. ***PageObject design pattern***
6. ***Android SDK*** 


***Important Note:*** 
- Framework is designed to perform parallel execution on different devices using TestNG on Test level.

--------------------------------------------------------------------------------------------
Getting the code:
--------------------------------------------------------------------------------------------
`git clone https://github.com/abdul-sathar/AppiumTestDemoBumble.git` (Clone the test suite)

--------------------------------------------------------------------------------------------
Configuration:
--------------------------------------------------------------------------------------------
In the file ***`config/capabilities.json`*** , please add desire capabilities for devices you want to use for execution, below capabilites need to be added.

- "platformName"
- "platformVersion"
- "deviceName"
- "automationName"
- "systemPort" (this port should be different for each device and can be provided any port number between range 8200 and 8299)
- "app" (path of app)

* For more information about Desire capability please go through this ***[Document about DesireCapability](https://appium.io/docs/en/writing-running-appium/caps/)***

--------------------------------------------------------------------------------------------
Prerequisite to run the framework:
--------------------------------------------------------------------------------------------
 - Install java and set "JAVA_HOME"
 - Install Android SDK and set "ANDROID_HOME" environment variable to point to this SDK
 - Install Appium, please refer this [document](https://appium.io/docs/en/about-appium/getting-started/?lang=en)
 - Setup Maven
 - Start Emulator or connect real device and set the desire capabilities for this device in ***`config/capabilities.json`***
 - for parallel execution, start two emulators or connect two device or combination of them
 - Start appium server for each device with different ports
 - Set the server port number in `android_test_runner.xml`

--------------------------------------------------------------------------------------------
Running the test suite:
--------------------------------------------------------------------------------------------

1. Clone the repository.

2. Navigate to 'AppiumTestDemoBumble' folder by  `cd AppiumTestDemoBumble` 

3. Execute the testNG tests by  `mvn clean test -PandroidTest` 
    ***OR*** Execute the cucumber tests by `mvn clean test -PandroidCucumber`


--------------------------------------------------------------------------------------------
Additional Info:
--------------------------------------------------------------------------------------------
* Tests can be found in `/src/test/java/com/bumble/testcases/` folder
* Cucumber Feature file can be found in `/src/test/resources/Features/` folder
* Page object classes can be found in `/src/main/java/com/bumble/pageObjects/` folder
* Cucumber step defination can be found in `/src/main/java/com/bumble/steps/` folder
* Utility methods can be found in `/src/main/java/com/bumble/utils/` folder
* Configuration for device capability can be found in `/config/capabilities.json` file
* Application under test can be found in `/app` folder

--------------------------------------------------------------------------------------------
Contact :  abdulsatharbeigh@gmail.com
--------------------------------------------------------------------------------------------
