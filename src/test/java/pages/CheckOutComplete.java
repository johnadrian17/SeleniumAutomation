package pages;

import common.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckOutComplete extends BaseTest {
    @FindBy(xpath = "//div/h2")
    private WebElement successfulText;
    @FindBy(id = "back-to-products")
    private WebElement homeButton;


    public void validateSuccessfulText() {
        boolean assertion = this.successfulText.isDisplayed();
        Assert.assertTrue(assertion);
    }
}
