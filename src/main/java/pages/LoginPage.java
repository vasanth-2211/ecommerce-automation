package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
        log.info("Entering username");
        type(usernameField, user);
    }

    public void enterPassword(String pass) {
        log.info("Entering password");
        type(passwordField, pass);
    }

    public void clickLoginButton() {
        log.info("Clicking login button");
        click(loginButton);
    }

    public InventoryPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new InventoryPage();
    }
    public String getErrorMessage(){
        return errorMessage.getText();
    }

}

