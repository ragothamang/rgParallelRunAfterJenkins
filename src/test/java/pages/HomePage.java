package pages;

import org.openqa.selenium.WebDriver;
import hooks.AppHooks;

public class HomePage extends AppHooks{
	public HomePage(WebDriver driver) {
		this.driver = driver;
		System.out.println("driver >>>    "+driver);
	}
	
	public HomePage clickOnWaffleIcon() {
		click(locateWebElement("xpath", "//div[contains(@class,'primary navLeft')]//button"));		
		return this;
	}

	public HomePage clickOnAppSearchBox() throws InterruptedException {		
		moveToWebElementAndClick(locateWebElement("xpath","//input[@type='search' and @placeholder='Search apps and items...']"));		
		return this;
	}
	
	public HomePage searchApp() throws InterruptedException {		
		type(locateWebElement("xpath","//input[@type='search' and @placeholder='Search apps and items...']"), "Sales");
		return this;
	}
}
