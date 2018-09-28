/**
 * 
 */
package com.epam.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.epam.config.DriverType;

/**
 * @author Farhaan_Shaik
 *
 */
public class WebDriverSingleton {
	private static WebDriver driver;
    /**.
     * type of the web driver
     */
    public static WebDriver getInstance(DriverType drivertype) {
    	if(driver == null) {
    		DesiredCapabilities capabalities = new DesiredCapabilities();
    		driver = drivertype.getDriver(capabalities);
    	}
    	return driver;
    }
}
