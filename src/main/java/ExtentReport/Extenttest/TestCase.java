package ExtentReport.Extenttest;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestCase {
public ExtentHtmlReporter htmlreport;
public ExtentReports extent;
public ExtentTest test;
@BeforeTest
public void setreport() {
	htmlreport=new ExtentHtmlReporter("./report.html");
	htmlreport.config().setEncoding("utf=8");
	htmlreport.config().setDocumentTitle("Automation report");
	htmlreport.config().setTheme(Theme.DARK);
	extent=new ExtentReports();
	extent.attachReporter(htmlreport);
	extent.setSystemInfo("Automation tester", "Vijay tomar");
}
@AfterTest
public void end() {
	extent.flush();
}
@Test
public void login()
{
	test=extent.createTest("Test case");
	System.out.println("Execting login test");
}
@Test
public void reg() {
	test=extent.createTest("User Reg");
	System.out.println("Reg successful");
}
@AfterMethod
public void tearDown(ITestResult results) {
	if(results.getStatus()==ITestResult.SUCCESS) {
	String methodName =results.getMethod().getMethodName();
	System.out.println(methodName);
	
	}
	
}
}