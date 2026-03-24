package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ExtentTestManager;

public class CheckOutPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(CheckOutPage.class);

    private By checkoutTitle = By.className("title");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");

    public void enterFirstName(String firstName){
        log.info("Entering first name");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Entering first name");
        }
        type(firstNameField, firstName);
    }
    public void enterLastName(String lastName){
        log.info("Entering last name");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Entering last name");
        }
        type(lastNameField,lastName);
    }
    public void enterPostalCode(String postalCode){
        log.info("Entering postal code");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Entering postal code");
        }
        type(postalCodeField,postalCode);
    }
    public void clickContinueButton(){
        log.info("Clicking continue");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Clicking continue");
        }
        click(continueButton);
    }

    public String getCheckoutTitle(){
        log.info("Getting checkout title");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Getting checkout title");
        }
        return getText(checkoutTitle);
    }

    public void fillCheckoutInformation(String first, String last, String zip) {
        log.info("Filling checkout information");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Filling checkout information");
        }
        enterFirstName(first);
        enterLastName(last);
        enterPostalCode(zip);
        clickContinueButton();
    }
}
