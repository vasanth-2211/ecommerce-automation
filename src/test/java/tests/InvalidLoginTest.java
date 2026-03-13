package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {


    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("abcd");
        loginPage.enterPassword("abcd");
        loginPage.clickLoginButton();


        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match"));    }

}
