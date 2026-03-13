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
    private String productContainer =
            "//div[text()='%s']/ancestor::div[@class='inventory_item']";

    public void addProductToCart(String productName){
        String addButtonXpath = String.format(productContainer+"//button[text()='Add to cart']", productName);
        click(driver.findElement(By.xpath(addButtonXpath)));
    }

    public String getCartCount(){
       return getText(shoppingCartBadge);
    }
    public void removeFromCart(){
        click(removeSauceLabsBackpack);
    }

    public void removeProductFromCart(String productName){
        String removeButtonXpath = String.format(productContainer+"//button[text()='Remove']", productName);
    }
    public void openProduct(String productName) {

        String productXpath =
                String.format("//div[text()='%s']", productName);

        click(driver.findElement(By.xpath(productXpath)));
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
