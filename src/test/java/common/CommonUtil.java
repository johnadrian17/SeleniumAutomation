package common;


import io.cucumber.java.Scenario;
import org.openqa.selenium.*;

public class CommonUtil {

    public void takeScreenshot(WebDriver driver, Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "testImg"); //stick it in the report
    }

    public void ScrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
