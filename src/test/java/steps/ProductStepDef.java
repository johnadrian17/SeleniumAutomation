package steps;

import common.BaseTest;
import common.CommonUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import java.io.IOException;
import java.util.List;

public class ProductStepDef extends BaseTest {
    private HomePage homepage = new HomePage();
    private CartPage cartpage = new CartPage();
    private CheckOutPage checkoutpage = new CheckOutPage();
    private CheckOutConfirmationPage checkoutconfirmationpage = new CheckOutConfirmationPage();
    private CheckOutComplete checkoutcomplete = new CheckOutComplete();

    private CommonUtil util = new CommonUtil();


    @When("^user sort products (.*)$")
    public void productSort(String DropdownItem) {
        homepage.selectOnDropdown(DropdownItem);
        util.takeScreenshot(getDriver(), getScenario());
    }


    @When("^user checkouts products$")
    public void checkoutProducts(DataTable productNames) throws IOException {
        List<List<String>> rows = productNames.asLists(String.class);
        for (List<String> column : rows) {
            homepage.addProductToCart(column.get(0));
            homepage.addProductToCart(column.get(1));
            homepage.addProductToCart(column.get(2));
        }
        homepage.clickCartIcon();
        util.takeScreenshot(getDriver(), getScenario());
        cartpage.clickCheckOutButtonButton();
        checkoutpage.fillInDetailsForCheckout();
        util.takeScreenshot(getDriver(), getScenario());
        checkoutpage.clickContinueButton();
        util.takeScreenshot(getDriver(), getScenario());
        checkoutconfirmationpage.clickFinishButton();
    }

    @When("^user checkouts (.*) products$")
    public void checkoutProduct(String productName) throws IOException {
        homepage.addProductToCart(productName);
        homepage.clickCartIcon();
        util.takeScreenshot(getDriver(), getScenario());
        cartpage.clickCheckOutButtonButton();
        checkoutpage.fillInDetailsForCheckout();
        util.takeScreenshot(getDriver(), getScenario());
        checkoutpage.clickContinueButton();
        util.takeScreenshot(getDriver(), getScenario());
        checkoutconfirmationpage.clickFinishButton();
    }

    @Then("^user should successfully checkout the products$")
    public void validateCartCount() {
        checkoutcomplete.validateSuccessfulText();
        util.takeScreenshot(getDriver(), getScenario());
    }

    @Then("^user should see Home page$")
    public void userIsInHomePage() {
        homepage.validateHomePage();
        util.takeScreenshot(getDriver(), getScenario());
    }

    @Then("^user will see sorted products$")
    public void viewSortedProducts() {
        homepage.getAllPrices();
    }
}
