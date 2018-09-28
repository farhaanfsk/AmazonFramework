package com.epam.pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Farhaan
 * web page displayed after a certain
 * book is searched
 */
public class BookresultPage extends Page {
	/**.
	 * web elements with their path in web page
	 */
	@FindBy(xpath = "//span[text()='4 Stars & Up']")
    private WebElement rating;
	@FindBy(xpath = "//i[@class='a-icon a-icon-extender-expand']")
    private WebElement seeMore;
	@FindBy(xpath = "//i[@class='a-icon a-icon-extender-collapse']")
    private WebElement seeLess;
	@FindBy(xpath = "//h2[text()='Selenium Testing Tools Cookbook -']")
	private WebElement searchedBook;
	@FindBy(xpath = "//span[text()='Paperback']")
	private WebElement paperback;
	@FindBy(name = "s-ref-checkbox-1318376031")
	private WebElement checkBox;
	@FindBy(className = "a-row a-expander-container a-expander-extend-container")
	private List<WebElement> list;
	private WebDriverWait wait;
	/**
	 * constructor for initialization
	 * @param driver
	 */
	public BookresultPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(getDriver(), 10);
		PageFactory.initElements(driver, this);
	}
	/**.
	 * method to display books with rating 4 and above
	 */
	public void rating4() {
		rating.click();
	}
	/**.
	 * method to display more related topics
	 * @return boolean value
	 */
	public boolean seeMore() {
		boolean visible = false;
		wait.until(ExpectedConditions.elementToBeClickable(seeMore)).click();
		visible = seeLess.isDisplayed();
		return visible;
	}
	/**.
	 * method to view less of related topics
	 * @return boolean value
	 */
	public boolean seeLess() {
		boolean visible = false;
		wait.until(ExpectedConditions.elementToBeClickable(seeLess)).click();
		visible = seeMore.isDisplayed();
		return visible;
	}
	/**.
	 * method to get the specific book name
	 * @return book name
	 */
	public String getBookName() {
		return searchedBook.getText();
	}
	/**.
	 * method to select paperback books
	 */
	public void selectPaperBack() {
		wait.until(ExpectedConditions.elementToBeClickable(paperback)).click();
	}
	/**.
	 * method to check if paperback check box
	 * is selected or not
	 * @return
	 */
	public boolean isSelectedPaperback() {
		return checkBox.isSelected();
	}
	public String getTitle() {
		return getDriver().getTitle();
	}

}