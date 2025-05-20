package pages;

import common.BaseTest;
import common.CommonUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BaseTest {

    @FindBy(id = "user-name")
    private WebElement inputUsername;
    @FindBy(name = "password")
    private WebElement inputPassword;
    @FindBy(css = "#login-button")
    private WebElement btnLogin;

    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement loginHeaderText;

    private CommonUtil util = new CommonUtil();

    public LoginPage() {
        goTo("https://www.saucedemo.com");
    }


    public void inputCredentials(String username, String password) throws InterruptedException {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        btnLogin.click();
        Thread.sleep(4000);
        util.takeScreenshot(driver, scenario);
    }

    public void validateLoginPage() {
        boolean assertion = this.loginHeaderText.isDisplayed();
        Assert.assertTrue(assertion);
        util.takeScreenshot(driver, scenario);
    }


}
