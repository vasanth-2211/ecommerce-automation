package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.JsonUtils;

public class ValidLoginTest extends BaseTest {
    @Test(groups = {"login","regression"})
    public void loginTest(){
        LoginPage loginPage = new LoginPage();

        String username = JsonUtils.getData("validUser", "username");
        String password = JsonUtils.getData("validUser", "password");

        InventoryPage inventoryPage = loginPage.login(
                username,
                password
        );
        String title = inventoryPage.getPageTitle();
        Assert.assertEquals(title, "Products");
    }
}
