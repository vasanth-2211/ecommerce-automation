package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.JsonUtils;

public class AddProductToCartTest extends BaseTest {
    @Test(groups = {"regression"})
    public void verifyAddProductToCart(){
        LoginPage loginPage = new LoginPage();

        String username = JsonUtils.getData("validUser", "username");
        String password = JsonUtils.getData("validUser", "password");

        InventoryPage inventoryPage = loginPage.login(
                username,
                password
        );

       inventoryPage.addToCart();
       String itemCount = inventoryPage.getCartCount();
       AssertionUtils.getAssert().assertEquals(itemCount,"1");
       AssertionUtils.assertAll();
    }
}
