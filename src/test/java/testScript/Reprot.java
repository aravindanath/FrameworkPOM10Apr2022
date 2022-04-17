package testScript;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Date;

public class Reprot {


  ExtentReports report;
   ExtentTest test;

    public static String ScreenshotFoulderPath;

    @BeforeMethod
    public void reportSetup(){
        Date date = new Date();
        String dateStamp = date.toString().replace(":","_").replace(" ","_");

//        String path = System.getProperty("user.dir")+dateStamp+"report.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
        sparkReporter.config().setReportName("OpenKart Regression Testing");
        sparkReporter.config().setDocumentTitle("OpenKart Automation Testing");
        sparkReporter.config().setReportName("Arvind");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setTheme(Theme.STANDARD);

        report = new ExtentReports();
        report.attachReporter(sparkReporter);
    }

    @Test
    public void testReport1(){
       ExtentTest  test1 =  report.createTest("Test Report 1");
       test1.info("Test Report pass");
        ExtentTest  test2 =  report.createTest("Test Report 2");
        test2.fail("Test Report fail");




    }

    @AfterMethod
    public void teardown(){
        report.flush();
    }


}
