package uiServices;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BrowserFactory;
import factory.DriverFactory;
import utils.ExtentReporter;

public class IPageActionsImp extends ExtentReporter{
	
	public   WebDriver driver;
//	public  static WebDriverWait wait;
	public   WebDriverWait wait;
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
			case "id": System.out.println("<<< Element is located by ID  >>>"); return driver.findElement(By.id(locatorValue)); 
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
			System.out.println(" <<< Clicked in the identifed element >>> ");
//			reportStep("The element : successfully clicke the element  : "+element, "PASS");
			reportStep("The data: entered successfully in the field :"+element, "PASS", takeSnap());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not clicked >> "+e.getMessage());
		}
	}

	public void type(WebElement element, CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
			wait.until(ExpectedConditions.visibilityOf(element));
			
			element.clear();
			element.sendKeys(keysToSend);
			System.out.println(" <<< Typed in the identifed element >>> "+element);
//			reportStep("The data: entered successfully in the field :"+element, "PASS");
			reportStep("The data: entered successfully in the field :"+element, "PASS", takeSnap());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not found>> rg  "+e.getMessage());
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

	public void moveToWebElementAndClick(WebElement element) {
		// TODO Auto-generated method stub
		try {			
//			wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
//			wait.until(ExpectedConditions.visibilityOf(element));
//			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
					  .withTimeout(Duration.ofSeconds(30))
					  .pollingEvery(Duration.ofSeconds(5))
					  .ignoring(NoSuchElementException.class);
			fWait.until(ExpectedConditions.visibilityOf(element));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
					
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not found>> "+e.getMessage());
		}
	}
	
	
	
	
	public long takeSnap() {

		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return number;
	}

	public void closeAllBrowsers() {
		try {
			extent.flush();
//			driver.close();
			driver.quit();
			reportStep("The opened browsers are closed","PASS", false);
//			reportStep("The opened browsers are closed  "+element, "PASS", takeSnap());
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","FAIL", false);
		}
	}

}
