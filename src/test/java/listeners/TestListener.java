package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import utils.ExtentManager;
import utils.ExtentTestManager;
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
    public void onTestFailure(ITestResult result) {
        String screenshotPath = ScreenshotUtils.captureScreenshot(result.getName());

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().fail(result.getThrowable());

            try {
                if (screenshotPath != null) {
                    ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath,result.getName());
                }
            } catch (Exception e) {
                e.printStackTrace();
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
