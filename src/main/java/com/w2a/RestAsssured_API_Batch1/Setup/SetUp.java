package com.w2a.RestAsssured_API_Batch1.Setup;

import java.lang.reflect.Method;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.w2a.RestAsssured_API_Batch1.Utils.ConfigProperties;
import com.w2a.RestAsssured_API_Batch1.Utils.ExcelReader;
import com.w2a.RestAsssured_API_Batch1.Utils.ExtentManager;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class SetUp {

	public static ConfigProperties testEnvironment;
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> classLevelExtentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testCaseLogger = new ThreadLocal<ExtentTest>();
	public static RequestSpecification requestSpec;

	public ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\simple.xlsx");

	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		ConfigFactory.setProperty("environment", "stage");
		testEnvironment = ConfigFactory.create(ConfigProperties.class);

		RestAssured.baseURI = testEnvironment.getBaseURI();
		RestAssured.basePath = testEnvironment.getBasePath();

		extent = ExtentManager.GetExtent();
		requestSpec=setRequestSpec();

	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {

	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {

		ExtentTest parent = extent.createTest(getClass().getSimpleName());

		classLevelExtentTest.set(parent);
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		// System.out.println("Execution of Test case:-" + method.getName() + "
		// started");

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {

		extent.flush();
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {

	}

	@BeforeClass(alwaysRun = true)
	public void afterSuite() {

	}

	public static RequestSpecification setRequestSpec() {

		return given().auth().basic(testEnvironment.getValidKey(), "").when();
	}
	
	public static ExtentTest extentLogger()
	{
		return testCaseLogger.get();
	}

}
