package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutFlowTest extends BaseTest {
    @Test(groups = {"checkout","regression"})
    public  void checkoutFlowTest(){
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = loginPage.login(
                "standard_user",
                "secret_sauce"
        );
        inventoryPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        CartPage cartPage = inventoryPage.goToCart();
        CheckOutPage checkOutPage = cartPage.clickCheckout();

        Assert.assertEquals(checkOutPage.getCheckoutTitle(),
                "Checkout: Your Information");
        checkOutPage.fillCheckoutInformation(
                "John",
                "Doe",
                "12345"
        );
    }

}
