/**
 * 
 */
package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * home page that is first launched
 * @author Farhaan_Shaik
 *
 */
public class HomePage extends Page {
	/**.
	 * web elements
	 */
	@FindBy(id = "nav-link-yourAccount")
	private WebElement signIn;
	/**
	 * constructor for initialization
	 * @param driver web driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	/**.
	 * method to sign in
	 * @return sign in page
	 */
	public SignInPage clickSignIn() {
		signIn.click();
		return new SignInPage(getDriver());
	}

}