package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);


    public static void initializeDriver() {
        log.info("Initializing WebDriver");
        if (driver.get() != null) {
            return;
        }

        String browser = ConfigReader.getProperty("browser");

       if (browser.equalsIgnoreCase("chrome")) {
           WebDriverManager.chromedriver().setup();
           driver.set(new ChromeDriver());
       }
       else if (browser.equalsIgnoreCase("firefox")) {
           WebDriverManager.firefoxdriver().setup();
           driver.set(new FirefoxDriver());
       }
       else if (browser.equalsIgnoreCase("safari")) {
           WebDriverManager.safaridriver().setup();
           driver.set(new SafariDriver());
       }
       else {
           throw new RuntimeException("Browser not supported: " + browser);
       }

        getDriver().manage().window().maximize();
    }
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        log.info("Quitting WebDriver");
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
