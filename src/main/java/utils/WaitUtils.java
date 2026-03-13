package utils;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
   private static WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
   public static void waitUntilElementIsVisible(WebElement element) {
       wait.until(ExpectedConditions.visibilityOf(element));
   }
   public static void waitUntilElementClickable(WebElement element) {
       wait.until(ExpectedConditions.elementToBeClickable(element));
   }
}
