/**
 * 
 */
package com.epam.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.base.TestBase;
import com.epam.listeners.ScreenshotListener;

/**
 * @author Farhaan_Shaik test class for automation of amazon services
 */
@Listeners(ScreenshotListener.class)
public class HomePageTest extends TestBase {
	@Test(dataProvider = "searchStrings")
	public void searchGoogle(final String searchKey) {
		WebDriver driver = getDriver();
		driver.manage().window().maximize();
		System.out.println("Search " + searchKey + " in google");
		driver.navigate().to("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		System.out.println("Enter " + searchKey);
		element.sendKeys(searchKey);
		System.out.println("submit");
		element.submit();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith(searchKey.toLowerCase());
			}
		});
		System.out.println("Got " + searchKey + " results");
	}

	@DataProvider
	private Object[][] searchStrings() {
		return new Object[][] { { "TestNG" }, { "Selenium" } };
	}

	

	@AfterClass
	public static void end() {
		closeDriver();
	}

}
