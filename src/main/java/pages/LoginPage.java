package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;


public class LoginPage extends BasePage {
    @FindBy(id ="user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void enterUsername(String user) {
        WaitUtils.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(user);
    }

    public void enterPassword(String pass) {
        WaitUtils.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(pass);
    }

    public void clickLoginButton() {
        WaitUtils.waitUntilElementClickable(loginButton);
        loginButton.click();
    }

    public InventoryPage login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new InventoryPage();
    }
}

