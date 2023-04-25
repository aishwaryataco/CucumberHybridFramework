package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterSuccessPage {

	WebDriver driver;
	    
	public RegisterSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountSuccessPage;
	
	
	public boolean getAccountSuccessMessage() {
		return accountSuccessPage.isDisplayed();
	}
}
