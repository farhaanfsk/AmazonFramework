/**
 * 
 */
package com.epam.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.epam.config.DriverFactory;

/**
 * @author Farhaan_Shaik
 *
 */
public class TestBase {
	/**>
	 * pool of driver factory 
	 */
    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    /**.
     * driver factory reference
     */
    private static DriverFactory driverfactory;
    /**.
     * initializing the driver
     */
    @BeforeSuite(alwaysRun = true)
    public static void instantiateDriver() {
    	driverfactory = new DriverFactory();
    	webDriverThreadPool.add(driverfactory);
    }
    /**.
     * returning the web driver  
     * @return driver
     */
    public static WebDriver getDriver() {
    	return driverfactory.getDriver();
    }
    /**.
     * closing the driver
     */
    public static void closeDriver() {
    	for(DriverFactory driverThread :  webDriverThreadPool) {
    		driverThread.quitDriver();
    	}
    }
}
