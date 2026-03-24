package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ExtentTestManager;

public class CartPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(CartPage.class);

    private By cartTitle = By.className("title");
    private By cartCheckoutButton = By.id("checkout");

   public String getCartTitle(){
       String title = getText(cartTitle);
       log.info(title);
       if (ExtentTestManager.getTest() != null) {
           ExtentTestManager.getTest().info(title);
       }
       return title;
    }
    public CheckOutPage clickCheckout(){
       String btnText = getText(cartCheckoutButton);
       log.info(btnText);
       if (ExtentTestManager.getTest() != null) {
           ExtentTestManager.getTest().info(btnText);
       }
       click(cartCheckoutButton);
       return new CheckOutPage();
   }
}
