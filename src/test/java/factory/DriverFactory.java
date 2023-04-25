package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
	 static WebDriver driver = null;
 public static WebDriver initializeBrowser(String browserName) {
	
	 if(browserName.equals("chrome")) {
		  driver = new ChromeDriver();
	 }else if(browserName.equals("edge")) {
		  driver = new EdgeDriver();
 }
	 return driver;
}
 public static WebDriver getDriver() {
	 return driver;
 }
}

