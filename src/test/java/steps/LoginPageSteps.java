package steps;

import common.CommonUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import java.io.IOException;

public class LoginPageSteps {
    Scenario scenario;
    private LoginPage loginpage = new LoginPage();
    private CommonUtil util = new CommonUtil();

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        loginpage.setScenario(scenario);
    }

    @Given("^user is in the product Home Page$")
    public void userInProductHomepage() throws InterruptedException {
        loginpage.inputCredentials("standard_user", "secret_sauce");
    }

    @Given("^user is successfully logged in$")
    public void userSuccessfullyLoggedIn() throws InterruptedException {
        loginpage.inputCredentials("standard_user", "secret_sauce");
    }

    @Given("^user is on login Page$")
    public void userIsInLoginPage() {
        loginpage.validateLoginPage();
    }

    @When("^user enters username and password$")
    public void userLoginWithCredentials() throws InterruptedException, IOException {
        String username  = util.testDataHandler("username");
        String password  = util.testDataHandler("password");
        loginpage.inputCredentials(username, password);
    }

}
