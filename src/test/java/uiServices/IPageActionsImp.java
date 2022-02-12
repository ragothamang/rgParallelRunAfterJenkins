package uiServices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BrowserFactory;
import factory.DriverFactory;
import utils.ExtentReporter;

public class IPageActionsImp extends ExtentReporter{
	
	public static WebDriver driver;
	public  static WebDriverWait wait;

	public String varFromPageActionsImp = "This is from PageActionImp Class";
	public IPageActionsImp() {
		System.out.println(" This is from  constructor IPageActionsImp() -->  " + varFromPageActionsImp   );
		
		
//		DriverFactory.getInstance().setDriver(bf.getChromeDriverInstance());
//		this.driver = DriverFactory.getInstance().getDriver();
		
		
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void setDriver(WebDriver driver){
		this.driver=driver;
	}
	
	public void jsClick(WebElement ele) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
			wait.until(ExpectedConditions.visibilityOf(ele));
			JavascriptExecutor jsExecute = (JavascriptExecutor)driver;
			jsExecute.executeScript("arguments[0].click();",ele);

		} catch (WebDriverException e) {
		}
	}
	public WebElement locateElement(String locValue) {
		return driver.findElement(By.id(locValue));
	}
	public WebElement locateWebElement(String locator, String locatorValue) {
		// TODO Auto-generated method stub

		try {
			switch (locator) {
			case "id": return driver.findElement(By.id(locatorValue)); 
			case "class": return driver.findElement(By.className(locatorValue));
			case "name": return driver.findElement(By.name(locatorValue));
			case "link":return driver.findElement(By.linkText(locatorValue));
			case "partialLink": return driver.findElement(By.partialLinkText(locatorValue));
			case "xpath": return driver.findElement(By.xpath(locatorValue));
			case "css_Selector": return driver.findElement(By.cssSelector(locatorValue));
			default:
				break;
			}

		}catch (Exception e) {
			// TODO: handle exception			
			System.out.println("Element not located >> "+e.getMessage());
		}
		return null;
	}

	
	public void click(WebElement element) {
		// TODO Auto-generated method stub
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
			wait.until(ExpectedConditions.visibilityOf(element));

			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not clicked >> "+e.getMessage());
		}
	}

	public void type(WebElement element, CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		try {
			element.clear();
			element.sendKeys(keysToSend);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not found>> "+e.getMessage());
		}
	}

	public void typeAndAppend(WebElement element, CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		try {			
			element.sendKeys(keysToSend);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not found>> "+e.getMessage());
		}
	}

	@Override
	public long takeSnap() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed","PASS", false);
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","FAIL", false);
		}
	}

}
