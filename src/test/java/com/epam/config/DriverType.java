/**
 * 
 */
package com.epam.config;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Farhaan_Shaik
 *
 */
public enum DriverType implements DriverSetup {
	/**.
	 * chrome enum with its driver
	 */
CHROME{
	public WebDriver getDriver(DesiredCapabilities capabalities) {
		String location = "src/resources/chromedriver";
    	System.setProperty("webdriver.chrome.driver", location);
		ChromeOptions options = new ChromeOptions();
		options.merge(capabalities);
		String nodeURL = "http://selenium:4444/wd/hub";
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.LINUX);
        try {
			return new RemoteWebDriver(new URL(nodeURL), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ChromeDriver(options);
	}
},
/**.
 * Firefox enum with its driver
 */
FIREFOX{

	public WebDriver getDriver(DesiredCapabilities capabalities) {
		String location = "C:\\Users\\Farhaan_Shaik\\eclipse-workspace\\AmazonFramework\\src\\resources\\geckodriver.exe";
    	System.setProperty("webdriver.gecko.driver", location);
		FirefoxOptions options = new FirefoxOptions(capabalities);
		return new FirefoxDriver(options);
	}
	
},
/**.
 * Edge browser enum with its driver
 */
EDGE{

	public WebDriver getDriver(DesiredCapabilities capabalities) {
		String location = "C:\\Users\\Farhaan_Shaik\\eclipse-workspace\\AmazonFramework\\src\\resources\\MicrosoftWebDriver.exe";
    	System.setProperty("webdriver.edge.driver", location);
		EdgeOptions options = new EdgeOptions();
		options.merge(capabalities);
		return new EdgeDriver();
	}
};
}
