package hooks;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import factory.BrowserFactory;
import factory.DriverFactory;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import uiServices.IPageActionsImp;
import utils.ExtentManager;
import utils.ExtentTestManager;

public class AppHooks extends IPageActionsImp{
	public String tempString;
	public  static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public WebDriver wdDriver = null;
	
	@BeforeSuite(groups = { "All" })
	public void beforeSuite() throws IOException {
		startReport();		
//		 ExtentManager.createInstance(fileName);	       
	}

	@BeforeClass(groups = { "All" })
	public void beforeClass() {		
		tempString = Thread.currentThread().getName();
		System.out.println("This from  @BeforeClass of AppHooks >> ThreadName  >>  "+ tempString );
		
		startTestCase(testCaseName, testDescription);
		
		BrowserFactory bf = new BrowserFactory();
		tlDriver.set(bf.getChromeDriverInstance());
		wdDriver = tlDriver.get();
		wdDriver.get("http://login.salesforce.com");
		
	}

	@BeforeMethod(groups = { "All" })
	public void beforeMethod() {
		// for reports
		
		
		
		driver = wdDriver;
		
		startTestModule(nodes);// each data row -> one testcase
		tlExtentTestTestStep.get().assignAuthor(authors);
		tlExtentTestTestStep.get().assignCategory(category);
	 
//		testStep.assignAuthor(authors);
//		testStep.assignCategory(category);	 
//		startApp("chrome");
		
		
//		DriverFactory.getInstance().setDriver(bf.getChromeDriverInstance());
//		driver = DriverFactory.getInstance().getDriver();
		

	}

	@AfterMethod(groups = { "All" })
	public void afterMethod() {
//		DriverFactory.getInstance().closeBrowser();
//		tlDriver.get().close();		
		closeAllBrowsers();
		
		tlDriver.remove();
	}

	

	@AfterSuite(groups = { "All" })
	public void afterSuite() throws IOException {
		endResult();
//		 ExtentManager.createInstance(fileName);
		 ExtentManager.getReporter().flush();
	}

}
