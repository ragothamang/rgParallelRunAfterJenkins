package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import hooks.AppHooks;

public class SalesAppHomePage extends AppHooks{
	public SalesAppHomePage(WebDriver driver) {
		this.driver = driver;
		System.out.println("driver >>>    "+driver);
	}
	
	public void verify_SalesApp_Landing_Page() {
		////div[@class='slds-context-bar__primary navLeft']//following::span[@title]
		System.out.println();
		WebElement element = locateWebElement("xpath", "//div[@class='slds-context-bar__primary navLeft']//following::span[@title]");
		verifyElementText(element,"Sales1");
	}

}
