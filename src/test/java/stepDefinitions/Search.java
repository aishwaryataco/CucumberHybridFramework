package stepDefinitions;

import org.junit.Assert;
import pages.HomePage;
import pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;

public class Search {
	HomePage homepage;
	SearchPage searchpage;
	WebDriver driver;
	@Given("User opens the Application")
	public void user_opens_the_application() {
		driver = DriverFactory.getDriver();
		
	
		
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {
		 homepage = new HomePage(driver);
		homepage.enterSearchText(validProductText);
		
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		 homepage = new HomePage(driver);
		homepage.clickOnSearchbutton();
		
	   
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
		 searchpage = new SearchPage(driver);
		
		Assert.assertTrue(searchpage.getSearchSuccessMessage());
		int a = 9/0;
	  
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
		homepage = new HomePage(driver);
		homepage.enterSearchText(invalidProductText);
		
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
	
		searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.displayInvalidProductmessage().contains("There is no product that matches the search criteria."));
	   
	}

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		 homepage = new HomePage(driver);

	}                                                
}
