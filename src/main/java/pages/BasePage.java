package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ExtentTestManager;
import utils.ScreenshotUtils;
import utils.WaitUtils;

public class BasePage {
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();

        if (this.driver == null) {
            throw new RuntimeException("WebDriver is null. Ensure driver is initialized before creating Page Objects.");
        }
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    protected void click(By locator) {

        try {

            WaitUtils.waitUntilElementClickable(getDriver(), locator).click();
            log.info("Element clicked");
            if (ExtentTestManager.getTest() != null) {
                ExtentTestManager.getTest().info("Clicked element");
            }

        } catch (Exception e) {

            String screenshotPath = ScreenshotUtils.captureScreenshot("step_failure");

            if (ExtentTestManager.getTest() != null) {
                ExtentTestManager.getTest().fail(
                        "Step Failed: Click Element",
                        com.aventstack.extentreports.MediaEntityBuilder
                                .createScreenCaptureFromPath(screenshotPath)
                                .build()
                );
            }

            throw e;
        }
    }
    protected void type(By locator, String text) {

        try {

            WebElement element = WaitUtils.waitUntilElementIsVisible(getDriver(), locator);
            element.clear();
            element.sendKeys(text);
            log.info("Text entered");

            if (ExtentTestManager.getTest() != null) {
                ExtentTestManager.getTest().info("Typed: " + text);
            }

        } catch (Exception e) {

            String screenshotPath = ScreenshotUtils.captureScreenshot("step_failure");

            if (ExtentTestManager.getTest() != null) {
                ExtentTestManager.getTest().fail(
                        "Step Failed: Type text",
                        com.aventstack.extentreports.MediaEntityBuilder
                                .createScreenCaptureFromPath(screenshotPath)
                                .build()
                );
            }

            throw e;
        }
    }

    protected String getText(By locator) {

        try {

            WebElement element = WaitUtils.waitUntilElementIsVisible(getDriver(), locator);
            String text = element.getText();
            log.info("Text fetched");

            if (ExtentTestManager.getTest() != null) {
                ExtentTestManager.getTest().info("Fetched text: " + text);
            }

            return text;

        } catch (Exception e) {

            String screenshotPath = ScreenshotUtils.captureScreenshot("step_failure");

            if (ExtentTestManager.getTest() != null) {
                ExtentTestManager.getTest().fail(
                        "Step Failed: Get text",
                        com.aventstack.extentreports.MediaEntityBuilder
                                .createScreenCaptureFromPath(screenshotPath)
                                .build()
                );
            }

            throw e;
        }
    }

    protected boolean isElementPresent(By locator) {
        return !getDriver().findElements(locator).isEmpty();
    }
}
