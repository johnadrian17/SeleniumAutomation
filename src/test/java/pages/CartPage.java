package pages;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BaseTest {

    @FindBy(xpath = "//div[@id='shopping_cart_container']/child::a/child::span")
    private WebElement cartItemQuantity;
    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;
    @FindBy(id = "checkout")
    private WebElement checkOutButton;


    public WebElement getElementProductNameInCart(String productname) {
        return driver.findElement(By.partialLinkText(productname));
    }

    public WebElement getElementProductDescInCart(String productname) {
        String xpath = "//a/div[text()='" + productname + "']/ancestor::div[@class='cart_item_label']/a/following-sibling::div[@class='inventory_item_desc']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getElementProductPriceInCart(String productname) {
        String xpath = "//a/div[text()='" + productname + "']/ancestor::div[@class='cart_item_label']/a/following-sibling::div[@class='item_pricebar']/div";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getElementProductRemoveButtonInCart(String productname) {
        String xpath = "//a/div[text()='" + productname + "']/ancestor::div[@class='cart_item_label']/a/following-sibling::div[@class='item_pricebar']/button";
        return driver.findElement(By.xpath(xpath));
    }
}
