package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.AssertionUtils;
import utils.ConfigReader;

public class BaseTest{
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser){
        log.info("Starting test setup");

        DriverFactory.initializeDriver(browser);
        AssertionUtils.initAssertions();
        String url = ConfigReader.getProperty("url");
        DriverFactory.getDriver().get(url);
    }
    @AfterMethod(alwaysRun = true)
    public void teardown(){
        log.info("Closing browser");
        DriverFactory.quitDriver();
        AssertionUtils.assertAll();

    }
    @BeforeSuite
    public void validateParallelExecution() {

        String browser = ConfigReader.getProperty("browser");

        int threadCount = Integer.parseInt(
                System.getProperty("dataproviderthreadcount", "1")
        );

        if(browser.equalsIgnoreCase("safari") && threadCount > 1){
            throw new RuntimeException(
                    "Safari does not support parallel execution. Use thread-count=1."
            );
        }
    }
}
