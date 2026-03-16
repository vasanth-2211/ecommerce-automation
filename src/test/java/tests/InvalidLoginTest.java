package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonUtils;

public class InvalidLoginTest extends BaseTest {


    @Test(groups = {"regression"})
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage();
        String username = JsonUtils.getData("invalidUser","username");
        String password = JsonUtils.getData("invalidUser","password");

        loginPage.login(username,password);

        loginPage.clickLoginButton();


        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match"));    }

}
