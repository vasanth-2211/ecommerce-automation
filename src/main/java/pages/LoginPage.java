package pages;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    WebDriver driver;
    public LoginPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="user-name")
    WebElement username;
    @FindBy(id="password")
    WebElement password;
    @FindBy(id="login-button")
    WebElement loginButton;

    public void enterUsername(String user) {
        username.sendKeys(user);
    }
    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }
    public void clickLoginButton() {
        loginButton.click();
    }


}
