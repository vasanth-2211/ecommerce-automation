package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void removeFromCart(){
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = loginPage.login(
                "standard_user"
                ,"secret_sauce"
        );
        inventoryPage.addToCart();
        inventoryPage.removeFromCart();

        Assert.assertEquals(inventoryPage.isCartEmpty(),true,"Cart is not empty after removing product");

    }
}
