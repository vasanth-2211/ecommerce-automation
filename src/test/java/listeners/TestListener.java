package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import utils.ExtentManager;
import utils.ScreenshotUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestListener implements  ITestListener, IAnnotationTransformer {
    private static ExtentReports extent = ExtentManager.getExtentReport();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = ScreenshotUtils.captureScreenshot(result.getName());
        test.get().fail(result.getThrowable());

        try{
            test.get().addScreenCaptureFromPath(screenshotPath);
        }catch (Exception e){
            e.printStackTrace();
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
