package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Retry_Analyser {

	@Test(retryAnalyzer = Generic_Utilities.RetryAnalyserImplementation.class)
	public void sample() {
		Assert.fail();
		System.out.println("Hi");
	}

}
