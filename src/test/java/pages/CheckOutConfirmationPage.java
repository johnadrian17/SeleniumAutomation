package pages;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutConfirmationPage extends BaseTest {

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement totalPrice;
    @FindBy(id = "//button[@id='cancel']")
    private WebElement cancelButton;
    @FindBy(id = "finish")
    private WebElement finishButton;


    public WebElement getElementProductName(String productname) {
        return driver.findElement(By.partialLinkText(productname));
    }

    public WebElement getElementProductDesc(String productname) {
        String xpath = "//a/div[text()='" + productname + "']/ancestor::a/following-sibling::div[@class='inventory_item_desc']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getElementProductPrice(String productname) {
        String xpath = "//a/div[text()='" + productname + "']/ancestor::a/following-sibling::div[@class='item_pricebar']/div";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getElementProductQty(String productname) {
        String xpath = "//a/div[text()='" + productname + "']/ancestor::div[@class='cart_item']/div[@class='cart_quantity']";
        return driver.findElement(By.xpath(xpath));
    }


    //This is the region for clicking the element
    public void clickFinishButton() {
        this.finishButton.click();
    }
    //This is the end region for clicking the element

}
