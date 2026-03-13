package base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest{
    DriverFactory driverFactory;

    @BeforeMethod
    public void setup(){
        DriverFactory.initializeDriver();
        DriverFactory.getDriver().get("https://www.saucedemo.com");

    }
    @AfterMethod
    public void teardown(){
        DriverFactory.getDriver().quit();
    }
}
