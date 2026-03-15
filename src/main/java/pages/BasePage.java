package pages;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
    protected void click(WebElement element) {
        WaitUtils.waitUntilElementClickable(element);
        element.click();
    }
    protected void type(WebElement element, String text) {
        WaitUtils.waitUntilElementIsVisible(element);
        element.sendKeys(text);
    }

    protected String getText(WebElement element){
        WaitUtils.waitUntilElementIsVisible(element);
        return element.getText();
    }
}
