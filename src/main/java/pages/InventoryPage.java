package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    @FindBy(className ="title")
    private WebElement pageTitle;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCardSauceLabsBackpack;
    @FindBy (className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;
    @FindBy(id="remove-sauce-labs-backpack")
    private WebElement removeSauceLabsBackpack;
    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public void addToCart(){
        click(addToCardSauceLabsBackpack);
    }
    public String getCartCount(){
       return getText(shoppingCartBadge);
    }
    public void removeFromCart(){
        click(removeSauceLabsBackpack);
    }
    public boolean isCartEmpty(){
        return driver.findElements(
                By.className("shopping_cart_badge")
        ).isEmpty();
    }
    public  CartPage goToCart(){
        click(cartIcon);
        return new CartPage();
    }
}
