package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {
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
        type(firstNameField, firstName);
    }
    public void enterLastName(String lastName){
        type(lastNameField,lastName);
    }
    public void enterPostalCode(String postalCode){
        type(postalCodeField,postalCode);
    }
    public void clickContinueButton(){
        click(continueButton);
    }

    public String getCheckoutTitle(){
        return getText(checkoutTitle);
    }

    public void fillCheckoutInformation(String first, String last, String zip) {
        enterFirstName(first);
        enterLastName(last);
        enterPostalCode(zip);
        clickContinueButton();
    }
}
