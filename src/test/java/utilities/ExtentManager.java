package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Date;

public class ExtentManager {

    static ExtentReports report;

    public static String ScreenshotFoulderPath;

    static String basePath = System.getProperty("user.dir");

    public static ExtentReports getReport(){

        if(report==null){
            Date date = new Date();
            System.out.println(date.toString().replace(":","_"));
            String reportFoulder = date.toString().replace(":","_");
            String path = basePath+"report"+reportFoulder+".html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
            sparkReporter.config().setReportName("OpenKart Regression Testing");
            sparkReporter.config().setDocumentTitle("OpenKart Automation Testing");
            sparkReporter.config().setEncoding("utf-8");
            sparkReporter.config().setTheme(Theme.STANDARD);

            report = new ExtentReports();
            report.attachReporter(sparkReporter);


        }
        return  report;
    }



}
