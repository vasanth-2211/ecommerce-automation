package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ExtentTestManager;

import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(InventoryPage.class);


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
        log.info(pageTitle.getText());
        ExtentTestManager.getTest().info("Page Title: " + pageTitle.getText());
        return getText(pageTitle);
    }

    public void addToCart(){
        log.info("Adding to cart...");
        ExtentTestManager.getTest().info("add to cart button");
        click(addToCardSauceLabsBackpack);
    }
    private String productContainer =
            "//div[text()='%s']/ancestor::div[@class='inventory_item']";

    public void addProductToCart(String productName){
        log.info("Adding product to cart: {}", productName);
        ExtentTestManager.getTest().info("Adding product to cart...");
        String addButtonXpath = String.format(productContainer+"//button[text()='Add to cart']", productName);
        click(getDriver().findElement(By.xpath(addButtonXpath)));
    }

    public String getCartCount(){
        log.info("Checking cart count");
        ExtentTestManager.getTest().info("Checking cart count");
        if (getDriver().findElements(By.className("shopping_cart_badge")).isEmpty()) {
            return "0";
        }
        return getText(shoppingCartBadge);
    }
    public void removeFromCart(){
        log.info("Removing cart from cart");
        ExtentTestManager.getTest().info("Removing cart from cart");
        click(removeSauceLabsBackpack);
    }

    public void removeProductFromCart(String productName){
        log.info("Removing product from cart: {}", productName);
        ExtentTestManager.getTest().info("Removing product from cart...");
        String removeButtonXpath = String.format(productContainer+"//button[text()='Remove']", productName);
        click(getDriver().findElement(By.xpath(removeButtonXpath)));
    }
    public void openProduct(String productName) {
        log.info("Opening product {}", productName);
        ExtentTestManager.getTest().info("Opening product...");

        String productXpath =
                String.format("//div[@class='inventory_item_name' and text()='%s']", productName);

        click(getDriver().findElement(By.xpath(productXpath)));
    }
    public boolean isCartEmpty(){
        log.info("Checking cart empty");
        ExtentTestManager.getTest().info("Checking cart empty");
        return getDriver().findElements(
                By.className("shopping_cart_badge")
        ).isEmpty();
    }
    public  CartPage goToCart(){
        log.info("Going to cart page");
        ExtentTestManager.getTest().info("Going to cart page");
        click(cartIcon);
        return new CartPage();
    }

    public void addRandomProductToCart(){
        log.info("Adding random product to cart");
        ExtentTestManager.getTest().info("Fetching all products from inventory");
        List<WebElement> products = getDriver().findElements(By.className("inventory_item"));
        int productCount = products.size();
        ExtentTestManager.getTest().info("Total products found: " + productCount);
        Random random = new Random();
        int randomProduct = random.nextInt(productCount);

        WebElement selectedProduct = products.get(randomProduct);

        String productName = selectedProduct.findElement(By.className("inventory_item_name")).getText();

        ExtentTestManager.getTest().info("Selected product: " + productName);
        WebElement addToCartButton = selectedProduct.findElement(By.tagName("button"));
        click(addToCartButton);

        ExtentTestManager.getTest().info("Clicking on product button");
    }
}
