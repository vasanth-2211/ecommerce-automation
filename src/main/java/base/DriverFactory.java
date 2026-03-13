package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver initializeDriver(String browser) {
       if (browser.equalsIgnoreCase("chrome")) {
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
       }
       else if (browser.equalsIgnoreCase("firefox")) {
           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();
       }
       else if (browser.equalsIgnoreCase("safari")) {
           WebDriverManager.safaridriver().setup();
           driver = new SafariDriver();
       }
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
