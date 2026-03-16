package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class RandomProductAddTest  extends BaseTest {
  @Test(groups = {"cart","regression"})
    public void addRandomProductToCartTest(){
      LoginPage loginPage = new LoginPage();
      InventoryPage inventoryPage = loginPage.login(
              "standard_user",
              "secret_sauce"
      );

      inventoryPage.addRandomProductToCart();
      String cartCount = inventoryPage.getCartCount();
      Assert.assertEquals(cartCount,"1");
  }
}
