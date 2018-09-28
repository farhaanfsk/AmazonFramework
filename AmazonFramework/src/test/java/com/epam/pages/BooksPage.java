package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**.
 * book page to display book relate
 * items
 * @author Farhaan_Shaik
 *
 */
public class BooksPage extends Page {
	/**.
	 * web elements with their annotation 
	 * path in web page
	 */
    @FindBy(id = "twotabsearchtextbox")
	private WebElement bookSearch;
    @FindBy(className = "nav-input")
	private WebElement search;
    @FindBy(id = "searchDropdownBox")
	private WebElement optionText;
    /**.
     * constructor for initialization
     * @param driver
     */
	public BooksPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	/**.
	 * search for a certain book
	 * @param searchkey book name
	 * @return book result page
	 */
	public BookresultPage search(String searchkey) {
		bookSearch.clear();
		bookSearch.sendKeys(searchkey);
		search.click();
		return new BookresultPage(getDriver());
	}
	/**.
	 * method to get name of book 
	 * if that specific book is present
	 * @return book name
	 */
	public String getoptionText() {
		Select option = new Select(optionText);
		return option.getFirstSelectedOption().getText();
	}

}