package com.epam.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Farhaan_Shaik
 *
 */
public class SignInPage extends Page {
	/**.
	 * web elements
	 */
	@FindBy(id = "ap_email")
	private WebElement email;
	
	@FindBy(id = "continue")
	private WebElement continueButton;
	
	@FindBy(id = "ap_password")
	private WebElement pwd;
	
	@FindBy(id = "signInSubmit")
	private WebElement signInSubmit;
	private WebDriverWait wait;
	/**.
	 * constructor for initialization
	 * @param driver web driver
	 */
	public SignInPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	/**.
	 * method to submit login details and
	 * redirect to the user home page
	 * @param email user email id
	 * @param pwd user password
	 * @return user home page
	 */
	public UserHomePage signInSubmit(String email, String pwd) {
		wait.until(ExpectedConditions.visibilityOf(this.email));
		this.email.sendKeys(email);
		continueButton.click();
		wait.until(ExpectedConditions.visibilityOf(this.pwd));
		this.pwd.sendKeys(pwd);
		signInSubmit.click();
		return new UserHomePage(getDriver());
	}
}