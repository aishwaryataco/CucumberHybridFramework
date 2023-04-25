package stepDefinitions;

import java.time.Duration;
import java.util.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;
public class Login {
WebDriver driver;
LoginPage loginpage;
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountOption();
		homepage.clickOnLoginOption();
		
	    
	}

	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
		 loginpage = new LoginPage(driver);
		 loginpage.emailTextField(emailText);
		
	   
	}


	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		 loginpage = new LoginPage(driver);
		loginpage.clickOnLoginOption();
	   
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		AccountPage accountSuccessPage = new AccountPage(driver);
		
	    Assert.assertTrue(accountSuccessPage.getchangeYourPasswordMessage());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		loginpage = new LoginPage(driver);
		loginpage.emailTextField(CommonUtils.generateEmailWithTimestamp());
		
	   
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		loginpage = new LoginPage(driver);
		loginpage.passwordTextField(invalidPasswordText);
		
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		
	    Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}


	@When("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
		loginpage = new LoginPage(driver);
		loginpage.passwordTextField(passwordText);
		
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		loginpage = new LoginPage(driver);
		loginpage.emailTextField("");
		
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		loginpage.passwordTextField("");
		
	}
	
}
