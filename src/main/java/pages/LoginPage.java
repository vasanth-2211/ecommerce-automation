package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    @FindBy(id ="user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void enterUsername(String user) {
        usernameField.sendKeys(user);
    }

    public void enterPassword(String pass) {
        passwordField.sendKeys(pass);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public InventoryPage login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new InventoryPage();
    }
}

