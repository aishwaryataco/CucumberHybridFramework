package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
		WebDriver driver;
		    
		public RegisterPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(id="input-firstname")
		private WebElement firstname;
		
		@FindBy(id="input-lastname")
		private WebElement lastname;
		
		@FindBy(id="input-email")
		private WebElement email;
		
		@FindBy(id="input-telephone")
		private WebElement telephone;
		
		@FindBy(id="input-password")
		private WebElement password;
		
		@FindBy(id="input-confirm")
		private WebElement confpassword;
		
		@FindBy(xpath="//input[@name='agree']")
		private WebElement privacyPolicyoption;
		
		@FindBy(xpath="//input[@value='Continue']")
		private WebElement continueButton;
		
		@FindBy(xpath="//input[@name='newsletter']")
		private WebElement newsletterOption;
		
		@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
		private WebElement duplicateEmailwarning;
		
		@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
		private WebElement firstNamewarningMessage;
		
		@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
		private WebElement lastNamewarningMessage;
		
		@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
		private WebElement emailwarningMessage;
		
		@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
		private WebElement telephonewarningMessage;
		
		@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
		private WebElement passwordwarningMessage;
		
		@FindBy(xpath="//input[@id='input-confpassword']/following-sibling::div")
		private WebElement confpasswordwarningMessage;

		
		public void firstNameText(String firstNameText) {
			firstname.sendKeys(firstNameText);
		}
		public void lastNameText(String lastNameText) {
			lastname.sendKeys(lastNameText);
		}
		public void emailText(String emailtext) {
			email.sendKeys(emailtext);
		}
		public void telephoneText(String telephoneText) {
			telephone.sendKeys(telephoneText);
		}
		public void passwordText(String passwordText) {
			password.sendKeys(passwordText);
		}
		public void confPasswordText(String confPasswordtext) {
			confpassword.sendKeys(confPasswordtext);
		}
		public void selectPrivacyPolicyoption() {
			privacyPolicyoption.click();
		}
		
		public void clickOnContinueButton() {
			continueButton.click();
		}
		
		public void selectNewsletteroption() {
			newsletterOption.click();
		}
		
		public String getDuplicateEmailWarningMessage() {
			return duplicateEmailwarning.getText();
		}
		
		public String displayFirstNamewarningMessage() {
			return firstNamewarningMessage.getText();
		}
		
		public String displayLastNamewarningMessage() {
			return lastNamewarningMessage.getText();
		}
		
		public String displayemailwarningMessage() {
			return emailwarningMessage.getText();
		}
		
		public String displayTelephonewarningMessage() {
			return telephonewarningMessage.getText();
		}
		
		public String displayPasswordwarningMessage() {
			return passwordwarningMessage.getText();
		}
		
		public String displayConfpasswordwarningMessage() {
			return confpasswordwarningMessage.getText();
		}
}
