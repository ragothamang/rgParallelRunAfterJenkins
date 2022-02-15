package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.AppHooks;

public class HomePage extends AppHooks{
	public HomePage(WebDriver driver) {
		this.driver = driver;
		System.out.println("driver >>>    "+driver);
	}
	
	public HomePage clickOnWaffleIcon() {
//		click(locateWebElement("xpath", "//div[@class='slds-icon-waffle']"));
		click(locateWebElement("xpath", "//div[contains(@class,'primary navLeft')]//button"));
		
		return this;
	}

	public HomePage clickOnAppSearchBox() throws InterruptedException {		
		Thread.sleep(2000);		
		
		moveToWebElement(locateWebElement("xpath","//input[@type='search' and @placeholder='Search apps and items...']"));		
		return this;
	}
	
	public HomePage searchApp() throws InterruptedException {
		Thread.sleep(200);
		type(locateWebElement("xpath","//input[@type='search' and @placeholder='Search apps and items...']"), "Sales");
		return this;
	}
}
