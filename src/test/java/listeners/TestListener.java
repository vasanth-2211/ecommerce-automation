package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.RetryAnalyzer;
import utils.ScreenshotUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestListener implements  ITestListener, IAnnotationTransformer {
    private static ExtentReports extent = ExtentManager.getExtentReport();


    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.assignAuthor("vazenth");
        test.assignCategory(result.getMethod().getGroups());
        ExtentTestManager.setTest(test);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        Object retry = result.getAttribute("retry");

        if(retry != null&& (boolean)retry) {
            ExtentTestManager.getTest().pass("Test passed after Retry(Flacky Test)");
        }else {
            ExtentTestManager.getTest().pass("Test Passed");
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {

        if (result.getThrowable() != null) {

            String screenshotPath = ScreenshotUtils.captureScreenshot(result.getName());

            ExtentTestManager.getTest().skip(result.getThrowable());

            try {
                if (screenshotPath != null) {
                    ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void onTestFailure(ITestResult result) {
        RetryAnalyzer retryAnalyzer = (RetryAnalyzer)result.getMethod().getRetryAnalyzer(result);
        if(retryAnalyzer==null || !retryAnalyzer.retry(result)){
        String screenshotPath = ScreenshotUtils.captureScreenshot(result.getName());

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().fail(result.getThrowable(),com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            }
        }
    }
    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
    @Override
    public void transform(
            ITestAnnotation annotation,
            Class testClass,
            Constructor testConstructor,
            Method testMethod) {

        annotation.setRetryAnalyzer(utils.RetryAnalyzer.class);
    }


}
