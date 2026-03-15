package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class AddMultipleProductsTest extends BaseTest {
   @Test(groups = {"regression"})
    public void addMultipleProducts() {
       LoginPage loginPage = new LoginPage();
       InventoryPage inventoryPage = loginPage.login(
               "standard_user",
               "secret_sauce"
       );
       inventoryPage.addProductToCart("Sauce Labs Backpack");
       inventoryPage.addProductToCart("Sauce Labs Bike Light");
       inventoryPage.addProductToCart("Sauce Labs Bolt T-Shirt");

       String itemsCount = inventoryPage.getCartCount();
       Assert.assertEquals(itemsCount,"3");

   }
}
