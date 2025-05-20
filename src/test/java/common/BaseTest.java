package common;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    protected static WebDriver driver;
    protected static Scenario scenario;
    protected static int defaultTimeout = 15;

    public BaseTest() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Adrian\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        PageFactory.initElements(driver, this);
    }

    public void goTo(String url) {
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Scenario getScenario() {
        return this.scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Adrian\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
    }

    public void afterScenario() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}