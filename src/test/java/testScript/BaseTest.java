package testScript;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.BasePage;

import java.io.File;
import java.util.Date;

public class BaseTest {


   public ExtentReports report;
   public ExtentTest test;

    public static String ScreenshotFoulderPath;

    @BeforeSuite
    public void reportSetup(){
        Date date = new Date();
        String dateStamp = date.toString().replace(":","_").replace(" ","_");

//      String path = System.getProperty("user.dir")+dateStamp+"report.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report"+dateStamp+".html");
        sparkReporter.config().setReportName("OpenKart Regression Testing");
        sparkReporter.config().setDocumentTitle("OpenKart Automation Testing");
        sparkReporter.config().setReportName("Arvind");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setTheme(Theme.STANDARD);
        report = new ExtentReports();
        report.attachReporter(sparkReporter);
    }


  protected   WebDriver driver;
    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( BasePage.getValue("url"));
    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        report.flush();
    }

//    @After
//    public void teardown(){
//        report.flush();
//    }



}
