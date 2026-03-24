package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ExtentTestManager;

import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(InventoryPage.class);

    private By pageTitle = By.className("title");
    private By addToCardSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By shoppingCartBadge = By.className("shopping_cart_badge");
    private By removeSauceLabsBackpack = By.id("remove-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    public String getPageTitle() {
        String title = getText(pageTitle);
        log.info(title);
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Page Title: " + title);
        }
        return title;
    }

    public void addToCart(){
        log.info("Adding to cart...");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("add to cart button");
        }
        click(addToCardSauceLabsBackpack);
    }
    private String productContainer =
            "//div[text()='%s']/ancestor::div[@class='inventory_item']";

    public void addProductToCart(String productName){
        log.info("Adding product to cart: {}", productName);
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Adding product to cart...");
        }
        String addButtonXpath = String.format(productContainer+"//button[text()='Add to cart']", productName);
        click(By.xpath(addButtonXpath));
    }

    public String getCartCount(){
        log.info("Checking cart count");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Checking cart count");
        }
        if (!isElementPresent(shoppingCartBadge)) {
            return "0";
        }
        return getText(shoppingCartBadge);
    }
    public void removeFromCart(){
        log.info("Removing cart from cart");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Removing cart from cart");
        }
        click(removeSauceLabsBackpack);
    }

    public void removeProductFromCart(String productName){
        log.info("Removing product from cart: {}", productName);
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Removing product from cart...");
        }
        String removeButtonXpath = String.format(productContainer+"//button[text()='Remove']", productName);
        click(By.xpath(removeButtonXpath));
    }
    public void openProduct(String productName) {
        log.info("Opening product {}", productName);
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Opening product...");
        }

        String productXpath =
                String.format("//div[@class='inventory_item_name' and text()='%s']", productName);

        click(By.xpath(productXpath));
    }
    public boolean isCartEmpty(){
        log.info("Checking cart empty");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Checking cart empty");
        }
        return !isElementPresent(shoppingCartBadge);
    }
    public  CartPage goToCart(){
        log.info("Going to cart page");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Going to cart page");
        }
        click(cartIcon);
        return new CartPage();
    }

    public void addRandomProductToCart(){
        log.info("Adding random product to cart");
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Fetching all products from inventory");
        }
        List<org.openqa.selenium.WebElement> products = getDriver().findElements(By.className("inventory_item"));
        int productCount = products.size();
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Total products found: " + productCount);
        }
        Random random = new Random();
        int randomProduct = random.nextInt(productCount);

        org.openqa.selenium.WebElement selectedProduct = products.get(randomProduct);

        String productName = selectedProduct.findElement(By.className("inventory_item_name")).getText();

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Selected product: " + productName);
        }
        org.openqa.selenium.WebElement addToCartButton = selectedProduct.findElement(By.tagName("button"));
        addToCartButton.click();

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info("Clicking on product button");
        }
    }
}
