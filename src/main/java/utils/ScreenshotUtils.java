package utils;

import base.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String captureScreenshot(String testName) {

        if (DriverFactory.getDriver() == null) {
            System.out.println("WebDriver is null. Screenshot skipped for test: " + testName);
            return null;
        }

        TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getDriver();
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        String folderPath = "test-output/screenshots";

        File directory = new File(folderPath);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = folderPath + "/" + testName + "_" + timestamp + ".png";

        File destinationFile = new File(filePath);

        try {
            FileHandler.copy(sourceFile, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
}
