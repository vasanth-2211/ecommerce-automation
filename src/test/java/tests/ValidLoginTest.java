package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.DataProviders;

public class ValidLoginTest extends BaseTest {
    @Test(dataProvider = "loginUsers",
            dataProviderClass = DataProviders.class,
            groups = {"login","smoke"}
    )
    public void loginTest(String username, String password) {
        LoginPage loginPage = new LoginPage();

        InventoryPage inventoryPage = loginPage.login(
                username,
                password
        );
        String title = inventoryPage.getPageTitle();
        AssertionUtils.getAssert().assertEquals(title,"Products","Inventory page should appear after login");
        AssertionUtils.assertAll();
    }
}
