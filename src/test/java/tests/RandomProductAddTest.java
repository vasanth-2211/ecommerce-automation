package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.JsonUtils;

public class RandomProductAddTest  extends BaseTest {
  @Test(groups = {"cart","regression"})
    public void addRandomProductToCartTest(){
    LoginPage loginPage = new LoginPage();

    String username = JsonUtils.getData("validUser", "username");
    String password = JsonUtils.getData("validUser", "password");

    InventoryPage inventoryPage = loginPage.login(
            username,
            password
    );
      inventoryPage.addRandomProductToCart();
      String cartCount = inventoryPage.getCartCount();
      AssertionUtils.getAssert().assertEquals(cartCount,"1");
      AssertionUtils.assertAll();
  }
}
