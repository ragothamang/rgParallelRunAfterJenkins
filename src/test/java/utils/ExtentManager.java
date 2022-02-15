package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static ExtentReports extent;
//    final static String filePath = "Extent.html";
    public static ExtentSparkReporter htmlReporter;
    
    public synchronized static ExtentReports getReporter() throws IOException {
        if (extent == null) {
        	htmlReporter = new ExtentSparkReporter("./reports/extentReport.html");
    		htmlReporter.loadXMLConfig("./src/test/resources/extent-config.xml");
            extent = new ExtentReports();            		
        }
        
        return extent;
    }
}
