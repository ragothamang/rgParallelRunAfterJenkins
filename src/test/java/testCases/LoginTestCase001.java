package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.AppHooks;
import pages.LoginPage;

public class LoginTestCase001 extends AppHooks{
	@BeforeTest
//	@BeforeClass
	public void setValues() {
		testCaseName = "TestCase Name : LoginTestCase001";
		testDescription = "TestCase Description : This is sample test case LoginTestCase001 ";
		nodes = "Test Node : LoginTestCase001";
		authors = "G Ragothaman";
		category = "Smoke";
//		dataSheetName = "TC001";
	}

	@Test
	public void loginTestCase() {
		System.out.println("  This is from -->   loginTestCase() ");
		new LoginPage(driver)
		.enterUserName("ragudom.selenium@gmail.com")
		.enterPassword("Selenium@143")
		.clickLoginButton();
	}
}
