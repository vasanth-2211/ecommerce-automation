package utils;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
   public static void waitUntilElementIsVisible(WebElement element) {
       WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(element));
   }
   public static void waitUntilElementClickable(WebElement element) {
       WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
       wait.until(ExpectedConditions.elementToBeClickable(element));
   }
}
