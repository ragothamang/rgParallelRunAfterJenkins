package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.AppHooks;
import pages.LoginPage;

public class OpenSalesAppTestCase002 extends AppHooks{
	@BeforeTest
//	@BeforeClass
	public void setValues() {
		testCaseName = "TestCase Name : OpenSalesAppTestCase002";
		testDescription = "TestCase Description : This is sample test case OpenSalesAppTestCase002 ";
		nodes = "Test Node : OpenSalesAppTestCase002";
		authors = "G Ragothaman";
		category = "Smoke";
//		dataSheetName = "TC001";
	}

	@Test
	public void loginTestCase() throws InterruptedException {
		System.out.println("  This is from -->   loginTestCase() ");
		new LoginPage(driver)
		.enterUserName("ragudom.selenium@gmail.com")
		.enterPassword("Selenium@143")
		.clickLoginButton()
		.clickOnWaffleIcon()
		.clickOnAppSearchBox()
		.searchApp();
		
	}

}
