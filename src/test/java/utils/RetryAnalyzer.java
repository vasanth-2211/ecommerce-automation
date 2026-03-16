package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int MAX_RETRIES = Integer.parseInt(ConfigReader.getProperty("maxRetries"));

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRIES) {
            retryCount++;

            if (ExtentTestManager.getTest() != null) {
                ExtentTestManager
                        .getTest()
                        .info("Retrying test - Attempt " + retryCount + " of " + MAX_RETRIES);
            }

            return true;
        }

        return false;
        }
    }

