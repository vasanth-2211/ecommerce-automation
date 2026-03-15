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

    @FindBy (css = "[data-test='error']")
    private WebElement errorMessage;

    public void enterUsername(String user) {
        type(usernameField, user);
    }

    public void enterPassword(String pass) {
        type(passwordField, pass);
    }

    public void clickLoginButton() {
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

