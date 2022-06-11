package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviderC {
    @DataProvider(name = "RegisterFunction")
    public static Object[][] getRegistrationData() throws IOException {
        String TESTDATA_SHEET_PATH = "src/test/testData/testData.xlsx";
        String SHEET_NAME = "RegisterData";
        return DataReader.getExcelData(TESTDATA_SHEET_PATH, SHEET_NAME);
    }

    @DataProvider(name = "LoginFunction")
    public static Object[][] getLoginData() throws IOException {
        String TESTDATA_SHEET_PATH = "src/test/testData/testData.xlsx";
        String SHEET_NAME = "LoginData";
        return DataReader.getExcelData(TESTDATA_SHEET_PATH, SHEET_NAME);
    }
}
