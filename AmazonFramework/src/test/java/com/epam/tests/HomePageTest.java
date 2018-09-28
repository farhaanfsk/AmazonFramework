/**
 * 
 */
package com.epam.tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.base.TestBase;
import com.epam.listeners.ScreenshotListener;
import com.epam.pages.BookresultPage;
import com.epam.pages.BooksPage;
import com.epam.pages.HomePage;
import com.epam.pages.SignInPage;
import com.epam.pages.UserHomePage;
import com.epam.utils.ExcelReader;

/**
 * @author Farhaan_Shaik
 * test class for automation of amazon services
 */	
@Listeners(ScreenshotListener.class)
public class HomePageTest extends TestBase{
	/**.
	 * to store text of the category selected
	 */
	public static String text;
	/**.
	 * To store the book name
	 */
	public static String book;
	/**.
	 * if paperback is selected
	 */
	public static boolean isPaperback;
	/**.
	 * if see more link is selected
	 */	
	public static boolean seeMoreSelected;
	/**.
	 * if see less link is selected
	 */
	public static boolean seeLessSelected;
	/**.
	 * web driver for web testing
	 */
	private static WebDriver driver;
	/**.
	 * set up method to set the driver and
	 * other url for test
	 */
	private static BooksPage bookpage;
	@BeforeClass
	public static void setUp(){
		driver = getDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		HomePage page = new HomePage(driver);
		SignInPage signin = page.clickSignIn();
		UserHomePage userHome = signin.signInSubmit("farhaanfsk@gmail.com", "3061833");
		bookpage = userHome.dropDown();
		text =(bookpage.getoptionText());
		BookresultPage bookresult = bookpage.search("Selenium with java");
		book = bookresult.getBookName();
		bookresult.rating4();
		seeMoreSelected = bookresult.seeMore();
		seeLessSelected = bookresult.seeLess();
		bookresult.selectPaperBack();
		isPaperback = bookresult.isSelectedPaperback();
		
	}
	@DataProvider(name = "searchdata")
	public Object[][] searchData(){
		return ExcelReader.getData();
	}
	@Test(dataProvider = "searchdata")
	public void bookSearchTest(String data) throws InterruptedException {
		BookresultPage bookresult = bookpage.search(data);
		Thread.sleep(1000);
		Assert.assertEquals("Amazon.in: "+data+": Books", bookresult.getTitle());
	}
	/**.
	 * Testing if a specific book is displayed or not
	 */
	@Test
	public void bookTest() {
		Assert.assertEquals("Selenium Testing Tools Cookbook -", book);
	}
	/**.
	 * Testing whether books category is selected
	 */
	@Test
	public void bookscategoryTest() {
		Assert.assertEquals("Books", text);
	}
	/**.
	 * Testing if see more displays more than 1 value
	 */
	@Test
	public void seeMoreTest() {
		Assert.assertTrue(isPaperback);
	}
	/**.
	 * Testing if see less displays less than 2 value
	 */
	@Test
	public void seeLessTest() {
		Assert.assertTrue(seeMoreSelected);
	}
	/**.
	 * Testing if paperback check box is checked or not
	 */
	@Test
	public void paperBackTest() {
		Assert.assertTrue(seeLessSelected);
	}
	/**.
	 * runs after all the tests are executed
	 */
	@AfterClass
	public static void end() {
		closeDriver(); 
	}

}
