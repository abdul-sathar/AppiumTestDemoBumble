package com.bumble.testcase;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * This class is the runner class for cucumber tests
 * @Developer: Abdul Sathar Beigh
 */
@CucumberOptions(features = "src/test/resources/Features", glue = {"com.bumble.steps"})
public class BumbleCucumberTestRunner extends AbstractTestNGCucumberTests {
}
