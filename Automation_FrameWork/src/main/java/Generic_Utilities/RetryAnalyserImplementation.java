package Generic_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for the IretryAnalyzer interface of testNG
 * 
 * @author SHAIK AFREED AHAMAD
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int count = 0;
	int retrycount = 3;// manual analysis

	public boolean retry(ITestResult result) {

		// 0<3 1<3 2<3 3<3-false
		while (count < retrycount) {
			count++;// 1 2 3
			return true;
		}
		return false;// stop retrying
	}

}
