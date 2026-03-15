package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetries = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetries) {
            retryCount++;
            System.out.println("Retrying test: "
                    + result.getName()
                    + " | Attempt: "
                    + retryCount);

            return true;
        }

        return false;
        }
    }

