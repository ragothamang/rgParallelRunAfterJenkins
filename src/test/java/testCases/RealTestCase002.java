package testCases;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.AppHooks;

public class RealTestCase002 extends AppHooks{
	
	@BeforeTest
//	@BeforeClass
	public void setValues() {
		testCaseName = "TestCase Name : RealTestCase002";
		testDescription = "TestCase Description : This is sample test case RealTestCase002 ";
		nodes = "Test Node : RealTestCase002";
		authors = "G Ragothaman";
		category = "Smoke";
//		dataSheetName = "TC001";
	}
	
	@Test
	public void RealTestCase002_Method001() {
		System.out.println("  This is from --> RealTestCase002_Method001()  ");
	}

}
