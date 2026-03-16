package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DataProviders;

public class ValidLoginTest extends BaseTest {
    @Test(dataProvider = "loginUsers",
            dataProviderClass = DataProviders.class,
            groups = {"login","regression"}
    )
    public void loginTest(String username, String password) {
        LoginPage loginPage = new LoginPage();

        InventoryPage inventoryPage = loginPage.login(
                username,
                password
        );
        String title = inventoryPage.getPageTitle();
        Assert.assertEquals(title, "Products");
    }
}
