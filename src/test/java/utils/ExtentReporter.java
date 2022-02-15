package utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class ExtentReporter {
	static Map<String, ExtentTest> extentTestMap = new HashMap<String, ExtentTest>();
	public static ThreadLocal<ExtentTest> tlExtentTestTestCase = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> tlExtentTestTestStep = new ThreadLocal<ExtentTest>();
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public  ExtentTest testCase,testStep;
	public String testCaseName, testDescription, nodes, authors,category;
	



	public synchronized void startReport() throws IOException {
		
		htmlReporter = new ExtentSparkReporter("./reports/extentReport.html");
		htmlReporter.loadXMLConfig("./src/test/resources/extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
//		 extent = ExtentManager.getReporter();
//		 ExtentTestManager.setReporter(extent);
//		tlExtentTestTestCase.set(testCase);
//		tlExtentTestTestStep.set(testStep);
		
	}
	
	public synchronized void endResult() throws IOException {		
		extent.flush();
//		ExtentManager.getReporter().flush();
	}
	
	public synchronized ExtentTest startTestCase(String testCaseName, String testDescription) {		
		testCase = extent.createTest(testCaseName, testDescription);		
//		extentTestMap.put((int) (long) (Thread.currentThread().getId()), testCase);
		extentTestMap.put(testCaseName, testCase);
		tlExtentTestTestCase.set(testCase);
		System.out.println("Tet Case Name >>   "+ testCaseName  +"Test Case Thread >>> "+  (Thread.currentThread().getId()));
		System.out.println("Class name >> "+ Thread.class.getName());
		/*
		tlExtentTestTestCase.set(extent.createTest(testCaseName, testDescription));
		testCase =  tlExtentTestTestCase.get();
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), tlExtentTestTestCase.get());		
		return tlExtentTestTestCase.get();
		*/
		
//		testCase = ExtentTestManager.createTest(testCaseName, testDescription);
		return tlExtentTestTestCase.get();
	}
	
	public synchronized ExtentTest startTestModule(String nodes) {
		
//		testStep = tlExtentTestTestCase.get().createNode(nodes);
//		testStep = extentTestMap.get((int) (long) (Thread.currentThread().getId())).createNode(nodes);
		
		/*
		tlExtentTestTestStep.set(tlExtentTestTestCase.get().createNode(nodes));
		testStep = tlExtentTestTestStep.get();		
		return tlExtentTestTestStep.get();
		*/
		
//		testStep = extentTestMap.get((int) (long) (Thread.currentThread().getId())).createNode(nodes);
		
//		tlExtentTestTestStep.set(tlExtentTestTestCase.get().createNode(nodes));
		System.out.println("Test Step Thread >>> "+ (int) (long) (Thread.currentThread().getId()));
		testStep = extentTestMap.get(testCaseName).createNode(nodes);
		tlExtentTestTestStep.set(testStep);
//		testStep = testCase.createNode(nodes);
		return tlExtentTestTestStep.get();
	}
	
//	public abstract long takeSnap();

	
	
	public synchronized void reportStep(String desc,String status, boolean bSnap) {
		
//		MediaEntityModelProvider img = null;
		Media img = null;
//		Media img = null;
		
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
//			testStep.info(desc);
		}
	}

	public synchronized void reportStep(String desc, String status) {
		reportStep(desc, status, true);		
	}
	public synchronized void reportStep(String desc, String status, long screenCaptureImgNumber) {
		reportStep(desc, status, true, screenCaptureImgNumber );		
	}
	
public synchronized void reportStep(String desc,String status, boolean bSnap, long screenCaptureImgNumber) {
		
//		MediaEntityModelProvider img = null;
		Media img = null;
//		Media img = null;
		
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = screenCaptureImgNumber;
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
//			testStep.info(desc);
		}
	}


	public long takeSnap() {
		// TODO Auto-generated method stub
		return 0;
	}

}
