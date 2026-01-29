package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductListPage;
import pages.ProductsDetailsPage;
import utilities.Utils;

public class StepDefinition
{
	Utils util;
	ProductListPage plist;
	ProductsDetailsPage pdetails;
	WebDriver driver;
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	@Given("I am on the {string} page")
	public void i_am_on_the_page(String string) 
	{
		
		util = new Utils();
		driver = util.setUp();
		util.viewLandingPage(driver);
	}

	@When("I navigate to {string} page")
	public void i_navigate_to_page(String string) 
	{
		plist = new ProductListPage(driver);
		
		plist.mouseHoverMen(driver, wait);
		plist.selectCategory(driver, wait);
	}

	@When("I apply filter by {string} and sort by {string}")
	public void i_apply_filter_by_and_sort_by(String string, String string2) 
	{
		plist = new ProductListPage(driver);
		
		plist.filterAndSort(driver, wait);
	}

	@When("I click on the first product on {string} page")
	public void i_click_on_the_first_product_on_page(String string) 
	{
		plist = new ProductListPage(driver);
		plist.viewProduct(wait);
	}

	@Then("I should see the {string} page")
	public void i_should_see_the_page(String string) 
	{
		pdetails = new ProductsDetailsPage(driver);
		pdetails.viewDetails(driver, wait);
	}
}
