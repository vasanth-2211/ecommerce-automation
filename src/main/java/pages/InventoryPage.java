package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    @FindBy(className ="title")
    private WebElement pageTitle;

    public String getPageTitle() {
        return pageTitle.getText();
    }
}
