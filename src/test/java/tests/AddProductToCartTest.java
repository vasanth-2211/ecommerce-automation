package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class AddProductToCartTest extends BaseTest {
   @Test
    public void verifyAddProductToCart(){
        LoginPage loginPage = new LoginPage();

       InventoryPage inventoryPage = loginPage.login(
               "standard_user",
               "secret_sauce"
       );

       inventoryPage.addToCart();
       String itemCount = inventoryPage.getCartCount();
       Assert.assertEquals(itemCount,"1");
    }
}
