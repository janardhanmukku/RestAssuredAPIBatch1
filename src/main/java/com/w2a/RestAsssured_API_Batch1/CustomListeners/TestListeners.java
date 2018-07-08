package com.w2a.RestAsssured_API_Batch1.CustomListeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.w2a.RestAsssured_API_Batch1.Setup.SetUp;

public class TestListeners extends SetUp implements ITestListener, ISuiteListener {

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		
		//extentLogger().info()

		String excepionMessage = Arrays.toString(arg0.getThrowable().getStackTrace());
		testCaseLogger.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
						+ " \n");


		String failureLogg = "This Test case got Failed";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testCaseLogger.get().log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult arg0) {
		String methodName = arg0.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testCaseLogger.get().skip(m);
		// extent.flush();

	}

	public void onTestStart(ITestResult arg0) {
		/*ExtentTest child = classLevelExtentTest.get().createNode(arg0.getMethod().getMethodName());
		testCaseLogger.set(child);

		testCaseLogger.get().log(Status.INFO, "Execution of Test case- " + arg0.getMethod().getMethodName() + " started");
	*/}

	public void onTestSuccess(ITestResult arg0) {

		String methodName = arg0.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Passed" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testCaseLogger.get().pass(m);
		// extent.flush();
	}

}
