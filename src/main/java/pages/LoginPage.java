package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ExtentTestManager;


public class LoginPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    private By errorMessage = By.cssSelector("[data-test='error']");

    public void enterUsername(String user) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Entering username");
        }
        log.info("Entering username");
        type(usernameField, user);
    }

    public void enterPassword(String pass) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Entering password");
        }
        log.info("Entering password");
        type(passwordField, pass);
    }

    public void clickLoginButton() {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Clicking login button");
        }
        log.info("Clicking login button");
        click(loginButton);
    }

    public InventoryPage login(String username, String password) {
        log.info("Entering username and password");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Entering username and password");
        }
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new InventoryPage();
    }
    public String getErrorMessage(){
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Fetching login error message");
        }
        log.info("Fetching login error message");
        return getText(errorMessage);
    }

}
