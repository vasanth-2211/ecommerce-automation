package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.JsonUtils;

public class RemoveFromCartTest extends BaseTest {

    @Test(groups = {"regression"})
    public void removeFromCart(){
        LoginPage loginPage = new LoginPage();

        String username = JsonUtils.getData("validUser", "username");
        String password = JsonUtils.getData("validUser", "password");

        InventoryPage inventoryPage = loginPage.login(
                username,
                password
        );
        inventoryPage.addToCart();
        inventoryPage.removeFromCart();

        Assert.assertEquals(inventoryPage.isCartEmpty(),true,"Cart is not empty after removing product");

    }
}
