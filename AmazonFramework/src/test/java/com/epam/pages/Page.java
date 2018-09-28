/**
 * 
 */
package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Farhaan_Shaik
 * Abstract class for web pages
 */
public abstract class Page {
	/**.
	 * web driver object
	 */
    private WebDriver driver;
    /**.
     * constructor for initialization
     * @param driver web driver
     */
    public Page(WebDriver driver) {
    	this.driver = driver;
    }
    /**.
     * getter method for web driver
     * @return
     */
	public WebDriver getDriver() {
		return driver;
	}
}
