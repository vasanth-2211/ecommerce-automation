package pages;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    public BasePage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
    }
}
