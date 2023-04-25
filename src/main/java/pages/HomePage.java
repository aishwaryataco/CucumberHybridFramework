package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
    
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//span[text()='My Account']")
private WebElement myAccountOption;

@FindBy(linkText="Login")
private WebElement loginOption;

@FindBy(linkText="Register")
private WebElement registerOption;

@FindBy(name="search")
private WebElement searchOption;

@FindBy(xpath="//button[contains(@class,'btn-default')]")
private WebElement searchButton;

public void clickOnMyAccountOption() {
	myAccountOption.click();
}
public void clickOnLoginOption() {
	loginOption.click();
}

public void clickOnRegisterOption() {
	registerOption.click();
}
	public void enterSearchText(String productText) {
		searchOption.sendKeys(productText);
}
	
	public void clickOnSearchbutton() {
		searchButton.click();
	}

}
