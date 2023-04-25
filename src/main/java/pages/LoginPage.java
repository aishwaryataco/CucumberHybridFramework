package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessageText;
	
	public void emailTextField(String emailText) {
		emailField.sendKeys(emailText);
	}
	public void passwordTextField(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	public void clickOnLoginOption() {
		loginButton.click();
	}
	
	public String getWarningMessageText() {
		return warningMessageText.getText();
	}
}
