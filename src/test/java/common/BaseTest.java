package common;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {


    protected static WebDriver driver;
    protected static Scenario scenario;

    public BaseTest() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();


    }

    public void goTo(String url) {
        driver.get(url);

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Scenario getScenario() {
        return this.scenario;
    }

}
