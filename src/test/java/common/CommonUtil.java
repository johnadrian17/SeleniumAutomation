package common;


import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;

import java.io.FileInputStream;
import java.io.IOException;

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

    public String testDataHandler(String dataName) throws IOException {
        String data = "";
        int firstRow = 0;
        int secondRow = 1;
        String excelFilePath = "testData.xlsx";

        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row rowForHeader = sheet.getRow(firstRow);

        for (int i = 0; i < rowForHeader.getLastCellNum(); i++) {
            if (rowForHeader.getCell(i).getStringCellValue().equals(dataName)) {
                Row rowForValue = sheet.getRow(secondRow);
                data = rowForValue.getCell(i).getStringCellValue();
            }
        }

        return data.toString();
    }

}
