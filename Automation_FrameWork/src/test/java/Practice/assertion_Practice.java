package Practice;

import org.testng.Assert;

public class assertion_Practice {

	public void sample() {
		String data = "abc";
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertTrue(data.contains("y"));
		System.out.println("step 3");
		System.out.println("step 4");

	}

}
