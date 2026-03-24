package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.JsonUtils;

public class CheckoutFlowTest extends BaseTest {
    @Test(groups = {"checkout","regression"})
    public  void checkoutFlowTest(){
        LoginPage loginPage = new LoginPage();

        String username = JsonUtils.getData("validUser", "username");
        String password = JsonUtils.getData("validUser", "password");

        InventoryPage inventoryPage = loginPage.login(
                username,
                password
        );
        inventoryPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        CartPage cartPage = inventoryPage.goToCart();
        CheckOutPage checkOutPage = cartPage.clickCheckout();

        AssertionUtils.getAssert().assertEquals(checkOutPage.getCheckoutTitle(),
                "Checkout: Your Information");
        checkOutPage.fillCheckoutInformation(
                "John",
                "Doe",
                "12345"
        );
        AssertionUtils.assertAll();
    }

}
