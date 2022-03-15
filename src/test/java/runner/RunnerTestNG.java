package runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class RunnerTestNG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		TestListenerAdapter tla = new TestListenerAdapter();
	    TestNG testng = new TestNG();
//	    List<String> suites = Lists.newArrayList();
	    List<String> suites = new ArrayList<String>();
	    suites.add(".//testngParallelClass.xml");//path to xml..
//	    suites.add("/simpleTutorials/testngParallelClass.xml");//path to xml..
//	    suites.add("./seleniumParallelRun/resources/testngParallelClass.xml");//path to xml..
//	    ./seleniumParallelRun/resources/extent-config.xml
//	    suites.add("c:/tests/testng2.xml");
	    
	    testng.setTestSuites(suites);
	    testng.addListener(tla);
	    testng.run();

	}

}
