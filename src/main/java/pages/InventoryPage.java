package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    @FindBy(className ="title")
    private WebElement pageTitle;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCardSauceLabsBackpack;
    @FindBy (className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public void addToCart(){
        click(addToCardSauceLabsBackpack);
    }
    public String getCartCount(){
       return getText(shoppingCartBadge);
    }
}
