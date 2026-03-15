package pages;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.WaitUtils;

public class BasePage {
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
    protected void click(WebElement element) {
        log.info("Clicking element: {}", element);

        WaitUtils.waitUntilElementClickable(element);
        element.click();
    }
    protected void type(WebElement element, String text) {
        log.info("Typing '{}' into element", text);
        WaitUtils.waitUntilElementIsVisible(element);
        element.sendKeys(text);
    }

    protected String getText(WebElement element){
        log.info("Fetching text from element");
        WaitUtils.waitUntilElementIsVisible(element);
        return element.getText();
    }
}
