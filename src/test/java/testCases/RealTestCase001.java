package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.AppHooks;

public class RealTestCase001 extends AppHooks{
	
	@BeforeTest
	public void setValues() {
		testCaseName = "TestCase Name : RealTestCase001";
		testDescription = "TestCase Description : This is sample test case RealTestCase001 ";
		nodes = "Test Node : RealTestCase001";
		authors = "G Ragothaman";
		category = "Smoke";
//		dataSheetName = "TC001";
	}
	
	
	@Test
	public void RealTestCase001_Method001() {
		System.out.println("  This is from --> RealTestCase001_Method001()  ");
	}

}
