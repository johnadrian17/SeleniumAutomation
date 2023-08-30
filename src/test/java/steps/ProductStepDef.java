package steps;

import common.CommonUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductPage;

import java.util.List;

public class ProductStepDef {
    Scenario scenario;
    private ProductPage productpage = new ProductPage();
    private CommonUtil util = new CommonUtil();


    @When("^user sort products (.*)$")
    public void productSort(String DropdownItem) {
        productpage.selectOnDropdown(DropdownItem);
        util.takeScreenshot(productpage.getDriver(), productpage.getScenario());
    }

    @Then("^user will see sorted products$")
    public void viewSortedProducts() {
        productpage.getAllPrices();
    }

    @When("^user add multiple products$")
    public void addProducts(DataTable productNames) {
        List<List<String>> rows = productNames.asLists(String.class);
        for (List<String> column : rows) {
            productpage.addProductToCart(column.get(0));
            productpage.addProductToCart(column.get(1));
            productpage.addProductToCart(column.get(2));
        }
        util.takeScreenshot(productpage.getDriver(), productpage.getScenario());
    }

    @Then("^user should add multiple products to the cart$")
    public void validateCartCount() {
        int expectedCartCount = 3;
        productpage.validateCartCount(expectedCartCount);
        util.takeScreenshot(productpage.getDriver(), productpage.getScenario());
    }

    @Then("^user is navigated to Home Page$")
    public void userIsInHomePage() {
        productpage.validateHomePage();
        util.takeScreenshot(productpage.getDriver(), productpage.getScenario());
    }
}
