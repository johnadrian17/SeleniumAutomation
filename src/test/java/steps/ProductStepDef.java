package steps;

import common.CommonUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class ProductStepDef {
    Scenario scenario;
    private HomePage homepage = new HomePage();
    private CommonUtil util = new CommonUtil();


    @When("^user sort products (.*)$")
    public void productSort(String DropdownItem) {
        homepage.selectOnDropdown(DropdownItem);
        util.takeScreenshot(homepage.getDriver(), homepage.getScenario());
    }

    @Then("^user will see sorted products$")
    public void viewSortedProducts() {
        homepage.getAllPrices();
    }

    @When("^user add multiple products$")
    public void addProducts(DataTable productNames) {
        List<List<String>> rows = productNames.asLists(String.class);
        for (List<String> column : rows) {
            homepage.addProductToCart(column.get(0));
            homepage.addProductToCart(column.get(1));
            homepage.addProductToCart(column.get(2));
        }
        util.takeScreenshot(homepage.getDriver(), homepage.getScenario());
    }

    @Then("^user should add multiple products to the cart$")
    public void validateCartCount() {
        int expectedCartCount = 3;
        homepage.validateCartCount(expectedCartCount);
        util.takeScreenshot(homepage.getDriver(), homepage.getScenario());
    }

    @Then("^user is navigated to Home Page$")
    public void userIsInHomePage() {
        homepage.validateHomePage();
        util.takeScreenshot(homepage.getDriver(), homepage.getScenario());
    }
}
