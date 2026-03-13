package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutNavigationTest extends BaseTest {

    @Test
    public void checkoutNavigationTest (){
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = loginPage.login(
                "standard_user",
                "secret_sauce"
        );
        inventoryPage.addToCart();
        CartPage cartPage = inventoryPage.goToCart();
        CheckOutPage checkOutPage = cartPage.clickCheckout();

        Assert.assertEquals(cartPage.getCartTitle(),"Checkout: Your Information");
    }
}
