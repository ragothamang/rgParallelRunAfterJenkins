package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

//@CucumberOptions(tags = "", features = "src/test/java/com/sf/automation/features", glue = {"com/sf/automation/steps","com/sf/automation/hooks"},
@CucumberOptions(tags = "", features = "src/test/resources/features", glue = {"steps","hooks"},
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
snippets = SnippetType.CAMELCASE)
public class CucumberRunner extends AbstractTestNGCucumberTests {
//public class CucumberRunnerTest  {

	
	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
	 

}