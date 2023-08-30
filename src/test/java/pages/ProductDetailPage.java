package pages;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends BaseTest {

    public WebElement getElementProductLink(String productname) {
        return driver.findElement(By.partialLinkText(productname));
    }

    public WebElement getElementProductDescription(String productname) {
        String xpath = "//a/div[text()='" + productname + "']/ancestor::a/following-sibling::div";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getElementAddToCartButton(String productname) {
        String xpath = "//a/div[text()='" + productname + "']/ancestor::div[@class='inventory_item_label']/following-sibling::div/button";
        return driver.findElement(By.xpath(xpath));
    }

}

