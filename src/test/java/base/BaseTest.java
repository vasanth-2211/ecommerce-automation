package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest{

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        DriverFactory.initializeDriver();
        String url = ConfigReader.getProperty("url");
        DriverFactory.getDriver().get(url);

    }
    @AfterMethod(alwaysRun = true)
    public void teardown(){
        DriverFactory.quitDriver();
    }
}
