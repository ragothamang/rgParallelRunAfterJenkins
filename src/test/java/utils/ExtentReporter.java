package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class ExtentReporter {
	public ThreadLocal<ExtentTest> tlExtentTestTestCase = new ThreadLocal<ExtentTest>();
	public ThreadLocal<ExtentTest> tlExtentTestTestStep = new ThreadLocal<ExtentTest>();
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public ExtentTest testCase,testStep;
	public String testCaseName, testDescription, nodes, authors,category;
	



	public void startReport() throws IOException {
		htmlReporter = new ExtentSparkReporter("./reports/extentReport.html");
		htmlReporter.loadXMLConfig("./src/test/resources/extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		tlExtentTestTestCase.set(testCase);
		tlExtentTestTestStep.set(testStep);
		
	}
	
	public void endResult() {
		extent.flush();
	}
	
	public synchronized ExtentTest startTestCase(String testCaseName, String testDescription) {
		testCase = extent.createTest(testCaseName, testDescription);
//		testCase = tlExtentTestTestCase.get();
//		testCase = extent.createTest(testCaseName, testDescription);
		tlExtentTestTestCase.set(testCase);
		return testCase;
	}
	
	public synchronized ExtentTest startTestModule(String nodes) {
//		testStep = tlExtentTestTestStep.get(); //can be commented
		testStep = testCase.createNode(nodes);
		tlExtentTestTestStep.set(testCase);
		return testStep;
	}
	
	public abstract long takeSnap();

	public void reportStep(String desc,String status, boolean bSnap) {
		
//		MediaEntityModelProvider img = null;
		Media img = null;
		
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
//			snapNumber = takeSnap();
			img = MediaEntityBuilder.createScreenCaptureFromPath
					("./../reports/images/"+snapNumber+".png").build();
		}		

		if(status.equalsIgnoreCase("PASS")) {
//			testStep.pass(desc, img);
			tlExtentTestTestStep.get().pass(desc, img);
		}else if(status.equalsIgnoreCase("FAIL")) {
//			testStep.fail(desc, img);
			tlExtentTestTestStep.get().fail(desc, img);
			throw new RuntimeException();
		}else if(status.equalsIgnoreCase("WARNING")) {
//			testStep.warning(desc, img);		
			tlExtentTestTestStep.get().warning(desc, img);
		}else {
			tlExtentTestTestStep.get().info(desc);
		}
	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

}
