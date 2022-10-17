package com.bumble.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * This class contains testdata for bumble app
 *
 * @Developer: Abdul Sathar Beigh
 */
public class TestDataProvider {
	
	@DataProvider(name = "testdata")
    public static Object[][] testData()
    {
        return new Object[][] { 
        	{"United Kingdom", "2333"} , {"Germany", "15237"}
        };
    }

}
