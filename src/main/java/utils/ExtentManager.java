package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    public static ExtentReports getExtentReport() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/extent-report.html");
            reporter.config().setReportName("Ecommerce Automation Report");
            reporter.config().setDocumentTitle("Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Environment",
                    System.getProperty("environment", "qa"));
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Tester", "Vasanth");

        }
    return extent;
    }
}
