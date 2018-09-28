/**
 * 
 */
package com.epam.config;

import static com.epam.config.DriverType.CHROME;

import org.openqa.selenium.WebDriver;

import com.epam.utils.WebDriverSingleton;

/**
 * @author Farhaan_Shaik
 *
 */
public class DriverFactory {
	/**.
	 * web driver
	 */
    private WebDriver driver;
    /**.
     * type of the web driver
     */
    private DriverType drivertype;
    /**.
     * constructor for initialization
     */
    public DriverFactory() {
        this.drivertype = CHROME;
    }
    /**.
     * getter for the web driver
     * @return web driver
     */
    public WebDriver getDriver() {
    	if(driver==null) {
        	driver = WebDriverSingleton.getInstance(drivertype);
    	}
    	return driver;
    }
    /**.
     * closing the driver
     */
    public void quitDriver() {
        if (null != driver) {
        	driver.close();
        	driver = null;
        }
    }
}
