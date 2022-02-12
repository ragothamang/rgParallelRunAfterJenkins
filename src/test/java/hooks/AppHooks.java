package hooks;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import factory.BrowserFactory;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import uiServices.IPageActionsImp;

public class AppHooks extends IPageActionsImp{
	public  ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	@Before
	public void beforeScenario() {
		System.out.println("This is before scenario ");
	}

	@AfterStep
	public void afterEachStep() {
		System.out.println("This is after every step ");
	}
	
	/*
	@BeforeClass
	public void beforeClass() {
		BrowserFactory bf = new BrowserFactory();
		tlDriver.set(bf.getChromeDriverInstance());
		driver = tlDriver.get();
		driver.get("http://www.google.com");
	}
	*/
	
	@BeforeSuite(groups = { "All" })
	public void beforeSuite() throws IOException {
		startReport();
	}

	@BeforeClass(groups = { "All" })
	public void beforeClass() {
		startTestCase(testCaseName, testDescription);
	}

	@BeforeMethod(groups = { "All" })
	public void beforeMethod() {
		// for reports
		startTestModule(nodes);// each data row -> one testcase
		testStep.assignAuthor(authors);
		testStep.assignCategory(category);	 
//		startApp("chrome");
		
		BrowserFactory bf = new BrowserFactory();
		tlDriver.set(bf.getChromeDriverInstance());
		driver = tlDriver.get();
		driver.get("http://login.salesforce.com");
	}

	@AfterMethod(groups = { "All" })
	public void afterMethod() {
		closeAllBrowsers();
	}

	

	@AfterSuite(groups = { "All" })
	public void afterSuite() {
		endResult();
	}

}
