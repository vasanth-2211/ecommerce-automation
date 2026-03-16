package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ExtentTestManager;

public class CheckOutPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(CheckOutPage.class);



    @FindBy(className = "title")
    private WebElement checkoutTitle;
    @FindBy(id = "first-name")
    private WebElement firstNameField;
    @FindBy(id = "last-name")
    private WebElement lastNameField;
    @FindBy(id = "postal-code")
    private WebElement postalCodeField;
    @FindBy(id = "continue")
    private WebElement continueButton;

    public void enterFirstName(String firstName){
        log.info("Entering first name");
        ExtentTestManager.getTest().info("Entering first name");
        type(firstNameField, firstName);
    }
    public void enterLastName(String lastName){
        log.info("Entering last name");
        ExtentTestManager.getTest().info("Entering last name");
        type(lastNameField,lastName);
    }
    public void enterPostalCode(String postalCode){
        log.info("Entering postal code");
        ExtentTestManager.getTest().info("Entering postal code");
        type(postalCodeField,postalCode);
    }
    public void clickContinueButton(){
        log.info("Clicking continue");
        ExtentTestManager.getTest().info("Clicking continue");
        click(continueButton);
    }

    public String getCheckoutTitle(){
        log.info("Getting checkout title");
        ExtentTestManager.getTest().info("Getting checkout title");
        return getText(checkoutTitle);
    }

    public void fillCheckoutInformation(String first, String last, String zip) {
        log.info("Filling checkout information");
        ExtentTestManager.getTest().info("Filling checkout information");
        enterFirstName(first);
        enterLastName(last);
        enterPostalCode(zip);
        clickContinueButton();
    }
}
