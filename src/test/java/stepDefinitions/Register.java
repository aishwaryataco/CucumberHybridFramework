package stepDefinitions;

import java.util.Date;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisterSuccessPage;
import utils.CommonUtils;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Register {
	WebDriver driver;
	RegisterPage registerpage;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountOption();
		homepage.clickOnRegisterOption();
		
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		 registerpage = new RegisterPage(driver);
		registerpage.firstNameText(dataMap.get("firstName"));
		registerpage.lastNameText(dataMap.get("lastName"));
		registerpage.emailText(CommonUtils.generateEmailWithTimestamp());
		registerpage.telephoneText(dataMap.get("telephone"));
		registerpage.passwordText(dataMap.get("password"));
		registerpage.confPasswordText(dataMap.get("password"));
		
	}
	@When("User enters the details into below fields with duplicate email adress")
	public void User_enters_the_details_into_below_fields_with_duplicate_email_adress (DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		 registerpage = new RegisterPage(driver);
			registerpage.firstNameText(dataMap.get("firstName"));
			registerpage.lastNameText(dataMap.get("lastName"));
			registerpage.emailText(dataMap.get("email"));
		registerpage.telephoneText(dataMap.get("telephone"));
		registerpage.passwordText(dataMap.get("password"));
		registerpage.confPasswordText(dataMap.get("password"));
	}

	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
	registerpage.selectPrivacyPolicyoption();
	    
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		registerpage = new RegisterPage(driver);
		registerpage.clickOnContinueButton();
	    
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		RegisterSuccessPage	registersuccesspage = new RegisterSuccessPage(driver);
		
	    Assert.assertTrue(registersuccesspage.getAccountSuccessMessage());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerpage.selectNewsletteroption();
		
	  	}


	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
	    Assert.assertTrue(registerpage.getDuplicateEmailWarningMessage().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	    
	}

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
		registerpage = new RegisterPage(driver);
		 Assert.assertTrue(registerpage.getDuplicateEmailWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(registerpage.displayFirstNamewarningMessage().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerpage.displayLastNamewarningMessage().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerpage.displayemailwarningMessage().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(registerpage.displayTelephonewarningMessage().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(registerpage.displayPasswordwarningMessage().contains("Password must be between 4 and 20 characters!"));
		
	}
	

}
