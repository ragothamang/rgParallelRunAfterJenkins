package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.AppHooks;
import pages.LoginPage;
import retry.RetryFailedTests;

public class OpenSalesAppTestCase001 extends AppHooks{
	@BeforeTest
//	@BeforeClass
	public void setValues() {
		testCaseName = "TestCase Name : OpenSalesAppTestCase002";
		testDescription = "TestCase Description : This is sample test case OpenSalesAppTestCase002 ";
		nodes = "Test Node : OpenSalesAppTestCase001";
		authors = "G Ragothaman";
		category = "Smoke";
//		dataSheetName = "TC001";
	}

	@Test(retryAnalyzer = RetryFailedTests.class)
//	@Test
	public void loginTestCase() throws InterruptedException {
		System.out.println("  This is from -->   loginTestCase() ");
		new LoginPage(driver)
		.enterUserName("ragudom.selenium@gmail.com")
		.enterPassword("Selenium@143")
		.clickLoginButton()
		.clickOnWaffleIcon()
		.clickOnAppSearchBox()
		.searchApp()
		.selectSalesApp()
		.verify_SalesApp_Landing_Page();	
	}
}
