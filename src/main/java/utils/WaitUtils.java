package utils;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WaitUtils {
    private static final Logger log = LoggerFactory.getLogger(WaitUtils.class);

    public static void waitUntilElementIsVisible(WebElement element) {
        log.info("Waiting for element to be visible");
       WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(element));
   }
   public static void waitUntilElementClickable(WebElement element) {
       log.info("Waiting for element visibility");
       WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
       wait.until(ExpectedConditions.elementToBeClickable(element));
   }
}
