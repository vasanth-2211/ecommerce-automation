package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest{
    DriverFactory driverFactory;

    @BeforeMethod
    public void setup(){
        DriverFactory.initializeDriver();
        String url = ConfigReader.getProperty("url");
        DriverFactory.getDriver().get(url);

    }
    @AfterMethod
    public void teardown(){
        DriverFactory.quitDriver();
    }
}
