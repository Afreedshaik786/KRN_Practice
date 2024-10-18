package Generic_Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ItestListeners interface of testNG
 * 
 * @author SHAIK AFREED AHAMAD
 */
public class ListenersImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		// for every @Test-> Test Method
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "------- Test Exceution start----------");

		// intimation of test execution to extent reports
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		// for every @Test is passed
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "------- Test Passed----------");

		// log the test status as pass
		test.log(Status.PASS, methodName + "------- Test Passed----------");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		// for every @Test is Failed
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "------- Test Failed----------");

		// print the exception for failure
		System.out.println(result.getThrowable());

		// log the test status as fail in extent reports
		test.log(Status.FAIL, methodName + "------- Test Failed----------");
		test.log(Status.INFO, result.getThrowable());

		// for capturing the screenshot
		Selenium_Utility s = new Selenium_Utility();
		Java_Utility j = new Java_Utility();
		String screenshotName = methodName + "-" + j.getSystemDate();
		try {
			String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);

			// attach screenshot to extent reports
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// for every @Test is Skipped
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "------- Test Skipped----------");

		// print the exception for failure
		System.out.println(result.getThrowable());

		// log the status as skip in extent reports
		test.log(Status.SKIP, methodName + "------- Test Skipped----------");
		test.log(Status.INFO, result.getThrowable());

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("-------Suite Execution Started------------");
		// basic configuration of extent reports
		ExtentSparkReporter htmlrep = new ExtentSparkReporter(
				".\\ExtentReports\\Report-" + new Java_Utility().getSystemDate() + ".html");
		htmlrep.config().setDocumentTitle("Execution Report");
		htmlrep.config().setTheme(Theme.DARK);
		htmlrep.config().setReportName("VTiger Execution Report");

		// set system info inside extent reports
		report = new ExtentReports();
		report.attachReporter(htmlrep);
		report.setSystemInfo("Base platform", "windows");
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Afreed");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("-------Suite Execution Finished------------------");

		// generate extent reports
		report.flush();
	}

}
