package pages;

import common.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutComplete extends BaseTest {
    @FindBy(xpath = "//div/h2[text()='THANK YOU FOR YOUR ORDER']")
    private WebElement successfulText;
    @FindBy(id = "back-to-products")
    private WebElement homeButton;
}
