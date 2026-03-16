package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.JsonUtils;

public class AddMultipleProductsTest extends BaseTest {
   @Test(groups = {"regression"})
    public void addMultipleProducts() {
      LoginPage loginPage = new LoginPage();

      String username = JsonUtils.getData("validUser", "username");
      String password = JsonUtils.getData("validUser", "password");

      InventoryPage inventoryPage = loginPage.login(
              username,
              password
      );
       inventoryPage.addProductToCart("Sauce Labs Backpack");
       inventoryPage.addProductToCart("Sauce Labs Bike Light");
       inventoryPage.addProductToCart("Sauce Labs Bolt T-Shirt");

       String itemsCount = inventoryPage.getCartCount();
       AssertionUtils.getAssert().assertEquals(itemsCount,"3");

   }
}
