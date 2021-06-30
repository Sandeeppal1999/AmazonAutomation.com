package com.amazonautomation.qa.utilties;

import com.amazonautomation.qa.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends BaseClass {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;
    public static XSSFSheet sheet;
    public static XSSFWorkbook workbook;
    public static String TESTDATASHEET_PATH = "C:/Users/Sandeep pal/IdeaProjects/" +
            "AmazonAutomation/src/main/java\\com/amazonautomation/qa/testdata/TestDataAddNewAddress.xlsx";

    public static Object[][] getTestData_AddNewAddress() {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATASHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheetAt(0);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                DataFormatter formatter = new DataFormatter();
                data[i][k] = formatter.formatCellValue(sheet.getRow(i + 1).getCell(k));
            }
        }
        return data;
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
}
