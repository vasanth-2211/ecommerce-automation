package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest{
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        log.info("Starting test setup");
        DriverFactory.initializeDriver();
        String url = ConfigReader.getProperty("url");
        DriverFactory.getDriver().get(url);

    }
    @AfterMethod(alwaysRun = true)
    public void teardown(){
        log.info("Closing browser");
        DriverFactory.quitDriver();
    }
}
