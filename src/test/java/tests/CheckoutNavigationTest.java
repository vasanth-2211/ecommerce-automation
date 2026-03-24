package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.JsonUtils;

public class CheckoutNavigationTest extends BaseTest {

    @Test(groups = {"regression"})
    public void checkoutNavigationTest (){
        LoginPage loginPage = new LoginPage();

        String username = JsonUtils.getData("validUser", "username");
        String password = JsonUtils.getData("validUser", "password");

        InventoryPage inventoryPage = loginPage.login(
                username,
                password
        );
        inventoryPage.addToCart();
        CartPage cartPage = inventoryPage.goToCart();
        CheckOutPage checkOutPage = cartPage.clickCheckout();

        AssertionUtils.getAssert().assertEquals(cartPage.getCartTitle(),"Checkout: Your Information");
        AssertionUtils.assertAll();
    }
}
