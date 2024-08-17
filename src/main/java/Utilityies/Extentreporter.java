package Utilityies;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Extentreporter {
    public  static ExtentReports generateExtentReport(){
        ExtentReports extentReport= new ExtentReports();
        File extentreportfle= new File(System.getProperty("user.dir")+"\\reports\\extentreport.html");
        ExtentSparkReporter sparkReporter= new ExtentSparkReporter(extentreportfle);

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Ninja results for test Automation Project");
        sparkReporter.config().setDocumentTitle("TN Automation project");
        sparkReporter.config().setTimeStampFormat("dd/MM/yyy hh:mm:ss");

        extentReport.attachReporter(sparkReporter);

        Properties configprob = new Properties();
        File fileprob = new File(System.getProperty("user.dir")+"\\src\\main\\TutorialsConfiguration\\config.properties");
        try {
            FileInputStream fis = new FileInputStream(fileprob);
            configprob.load(fis);
        } catch(Throwable e){
            e.printStackTrace();

        }
        extentReport.setSystemInfo("Application URL:",configprob.getProperty("url"));
        extentReport.setSystemInfo("Browser Name :",configprob.getProperty("browser"));
        extentReport.setSystemInfo("Email",configprob.getProperty("email"));
        extentReport.setSystemInfo("password",configprob.getProperty("password"));

        extentReport.setSystemInfo("Operating System ",System.getProperty("os.name"));
        extentReport.setSystemInfo("UserName",System.getProperty("user.name"));
        extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));

        return extentReport;
    }
}
