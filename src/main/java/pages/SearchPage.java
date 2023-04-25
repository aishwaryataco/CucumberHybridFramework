package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
    
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement SearchSuccessMessage;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement invalidProductmessage;
	
	
	public boolean getSearchSuccessMessage() {
		return SearchSuccessMessage.isDisplayed();
	}
	
	public String displayInvalidProductmessage() {
		return invalidProductmessage.getText();
	}
}
