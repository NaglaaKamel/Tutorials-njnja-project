package listeners;

import Utilityies.Extentreporter;
import Utilityies.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class mylisteners implements ITestListener {
    ExtentReports extentReport;
    ExtentTest extentTest;
    @Override
    public void onStart(ITestContext context) {
         extentReport = Extentreporter.generateExtentReport();
        System.out.println("Execution of project tests started");
    }
    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        extentTest= extentReport.createTest(testName);
        extentTest.log(Status.INFO,testName +" "+"Started Executing");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getName();
        extentTest.log(Status.PASS,testName +" "+"got successfully Executed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        WebDriver driver = null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        }catch(Throwable e){
            e.printStackTrace();
        }
           //taking screen shot
           String destinationscreenshotpath=utilities.capturescreenshot(driver,result.getName());
            extentTest.addScreenCaptureFromPath(destinationscreenshotpath);
            extentTest.log(Status.INFO,result.getThrowable());
            extentTest.log(Status.FAIL,testName +" "+"got failted");
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.SKIP,testName +" "+"got skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
        String pathofExtentreportfile= System.getProperty("user.dir")+"\\reports\\extentreport.html";
        File extentreport=new File(pathofExtentreportfile);
        try {
            Desktop.getDesktop().browse(extentreport.toURI());
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
