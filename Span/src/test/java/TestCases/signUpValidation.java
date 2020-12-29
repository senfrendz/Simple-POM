package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.Baseclass;
import Pages.Register;
import Pages.TestDataParse_Excel;

public class signUpValidation extends Baseclass implements ITestListener {
	
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ExtentTest testCase;
	
	@DataProvider
	public Iterator<Object[]> TestDataParse() throws IOException {
			ArrayList<Object[]> excelData= TestDataParse_Excel.readFromExcel();
		return excelData.iterator();
	}
	
	@BeforeTest
	public void configExtentReport() {
		 extent = new ExtentReports();
		 htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		extent.attachReporter(htmlReporter);	
	}
	
	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.automationtesting.in/Index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="TestDataParse")
	public void verifySignUp(String SignUp_Email,String firstName,String lastName,String emailAddr,String phone,String countryName) throws 
	InterruptedException, IOException {
	testCase = extent.createTest("Verify Registration Process");
		Register.Signup(SignUp_Email,firstName, lastName, emailAddr, phone, countryName);
	}
		
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//	testCase.log(Status.PASS, "TestCase Passed");

	}

	public void onTestFailure(ITestResult result) {
	//	testCase.log(Status.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		extent.flush();
	}
	}
	
	

