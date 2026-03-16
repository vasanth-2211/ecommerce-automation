package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static WebDriver safariDriver = null;
    private static final Object safariLock = new Object();
    private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);


    public static void initializeDriver(String browser) {
        boolean headless =  Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        log.info("Initializing WebDriver");
        if (driver.get() != null) {
            return;
        }

        if (browser == null || browser.isEmpty()) {
            browser = ConfigReader.getProperty("browser");
        }
        log.info("Browser selected from config: {}", browser);

       if (browser.equalsIgnoreCase("chrome")) {
           WebDriverManager.chromedriver().setup();

           ChromeOptions options = new ChromeOptions();
           options.addArguments("--start-maximized");

           if (headless) {
               options.addArguments("--headless=new");
           }
           driver.set(new ChromeDriver());
       }
       else if (browser.equalsIgnoreCase("firefox")) {
           WebDriverManager.firefoxdriver().setup();
           driver.set(new FirefoxDriver());
       }
       else if (browser.equalsIgnoreCase("safari")) {
           log.info("Starting Safari browser in single-thread mode");
           synchronized (safariLock) {
               if (safariDriver == null) {
                   safariDriver = new SafariDriver();
               }
               driver.set(safariDriver);
           }
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
            if (driver.get() instanceof SafariDriver) {
                synchronized (safariLock) {
                    if (safariDriver != null) {
                        safariDriver.quit();
                        safariDriver = null;
                    }
                }
            } else {
                driver.get().quit();
            }
            driver.remove();
        }
    }
}
