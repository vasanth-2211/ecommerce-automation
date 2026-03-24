package utils;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WaitUtils {
    private static final Logger log = LoggerFactory.getLogger(WaitUtils.class);
    private static final int TIMEOUT = Integer.parseInt(ConfigReader.getProperty("timeout"));


    public static WebElement waitUntilElementIsVisible(WebDriver driver, By locator) {
        log.info("Waiting for element to be visible");
        ExtentTestManager.getTest().info("Waiting for element to be visible");
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitUntilElementIsVisible(WebElement element) {
        log.info("Waiting for WebElement to be visible");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Waiting for WebElement to be visible");
        }
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }
   public static WebElement waitUntilElementClickable(WebDriver driver, By locator) {
       log.info("Waiting for element visibility");
       ExtentTestManager.getTest().info("Waiting for element visibility");
       return new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(locator));
   }
    public static void waitForUrlContains(WebDriver driver, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.urlContains(text));
    }
}
