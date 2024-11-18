package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    public static void initReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
        reporter.config().setReportName("Calculator Test Report");
        reporter.config().setDocumentTitle("Automation Report");
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
    }

    public static void setTest(String testName) {
        extentTest = extentReports.createTest(testName);
    }

    public static void log(String message) {
        if (extentTest != null) {
            extentTest.info(message);
        }
    }

    public static void logScreenshot(AppiumDriver<?> driver, String message) {
        String screenshotPath = takeScreenshot(driver);
        extentTest.info(message).addScreenCaptureFromPath(screenshotPath);
    }

    public static void flushReports() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    private static String takeScreenshot(AppiumDriver<?> driver) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotPath = "target/screenshots/screenshot_" + timestamp + ".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}