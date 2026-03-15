package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(CartPage.class);

    @FindBy(className = "title")
    private WebElement cartTitle;
   @FindBy(id="checkout")
    private WebElement cartCheckoutButton;

   public String getCartTitle(){
       log.info(cartTitle.getText());
        return cartTitle.getText();
    }
    public CheckOutPage clickCheckout(){
       log.info(cartCheckoutButton.getText());
    click(cartCheckoutButton);
    return new CheckOutPage();
   }
}
