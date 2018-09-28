package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**.
 * user specific home page
 * @author Farhaan_Shaik
 *
 */
public class UserHomePage extends Page {
	/**.
	 * web elements
	 */
	@FindBy(id = "nav-link-shopall")
	private  WebElement shopByCategory;
	
	@FindBy(xpath = "//span[text()='Books']")
	private  WebElement booksCategory;
	
	@FindBy(xpath = "//span[text()='All Books']")
	private  WebElement allBooks;
	/**.
	 * action for hover operation
	 */
	private Actions action;
	private WebDriverWait wait;
	/**.
	 * constructor for initialization
	 * @param driver web driver
	 */
	public UserHomePage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 5);
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	/**.
	 * method to redirect to book category page
	 * @return books page
	 */
	public BooksPage dropDown() {
	    wait.until(ExpectedConditions.elementToBeClickable(shopByCategory));
		action.moveToElement(shopByCategory).perform();
		wait.until(ExpectedConditions.elementToBeClickable(booksCategory));
		action.moveToElement(booksCategory).perform();
	    allBooks.click();
	    return new BooksPage(getDriver());
	}

}