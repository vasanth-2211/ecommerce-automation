package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ExtentTestManager;


public class LoginPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id ="user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy (css = "[data-test='error']")
    private WebElement errorMessage;

    public void enterUsername(String user) {
        ExtentTestManager.getTest().info("Entering username");
        log.info("Entering username");
        type(usernameField, user);
    }

    public void enterPassword(String pass) {
        ExtentTestManager.getTest().info("Entering password");
        log.info("Entering password");
        type(passwordField, pass);
    }

    public void clickLoginButton() {
        ExtentTestManager.getTest().info("Clicking login button");
        log.info("Clicking login button");
        click(loginButton);
    }

    public InventoryPage login(String username, String password) {
        log.info("Entering username and password");
        ExtentTestManager.getTest().info("Entering username and password");
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new InventoryPage();
    }
    public String getErrorMessage(){
        return errorMessage.getText();
    }

}

