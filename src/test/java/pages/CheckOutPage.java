package pages;

import common.BaseTest;
import common.CommonUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class CheckOutPage extends BaseTest {
    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement postalCode;
    @FindBy(id = "cancel")
    private WebElement cancelButton;
    @FindBy(id = "continue")
    private WebElement continueButton;

    private CommonUtil util = new CommonUtil();

    public void fillInDetailsForCheckout() throws IOException {
        this.firstName.sendKeys(util.testDataHandler("first name"));
        this.lastName.sendKeys(util.testDataHandler("last name"));
        this.postalCode.sendKeys(util.testDataHandler("zip code"));
    }

    //This is the region for clicking the element
    public void clickContinueButton() {
        this.continueButton.click();
    }
    //This is the end region for clicking the element
}
