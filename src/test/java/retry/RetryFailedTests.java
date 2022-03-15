package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer{

	private int count = 0;
	private int retries = 3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<retries) {
			System.out.println(" Retry count >> "+ count);
			count++;
			return true;
			
		}
		return false;
	}

}
