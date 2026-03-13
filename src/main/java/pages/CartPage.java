package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
   @FindBy(className = "title")
    private WebElement cartTitle;
   @FindBy(id="checkout")
    private WebElement cartCheckoutButton;

   public String getCartTitle(){
        return cartTitle.getText();
    }
    public CheckOutPage clickCheckout(){
    click(cartCheckoutButton);
    return new CheckOutPage();
   }
}
