/**
 * 
 */
package com.epam.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Farhaan_Shaik
 *
 */
public interface DriverSetup {
	/***.
	 * method to return driver with 
	 * the desired capabalites
	 * @param capabalities of the browser
	 * @return web driver
	 */
    WebDriver getDriver(DesiredCapabilities capabalities);
}
