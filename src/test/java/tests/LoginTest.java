package tests;

import actions.Browser_Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Account;
import pages.Home;
import pages.Login;
import utilities.DataProviderC;
import utilities.ScreenShot;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    Browser_Actions bAction;
    Home homePage;
    Login loginPage;
    Account myAcc;
    static String className ;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws Exception {
        className = this.getClass().getName();
        bAction = new Browser_Actions(className,browser,false);
        bAction.navigateURL(className,"https://demo.nopcommerce.com/");
        bAction.maximizeWindow(className);
    }

    @Deprecated
    @Test(dataProvider = "LoginFunction", dataProviderClass = DataProviderC.class)
    public void LoginWithValidCred (String email, String password)  {
        homePage = new Home(className);
        loginPage = homePage.clickOnLogin();
        myAcc = loginPage.loginUser(email, password);
        assertTrue(myAcc.getLoginStatus(), "User Didn't Login Successfully");
    }


    @AfterTest
    public void teardown()
    {
        bAction.endSession(className);
    }

    @AfterMethod
    public void recordResult(ITestResult result) throws IOException {
        ScreenShot.takeScreenShot(Browser_Actions.drivers.get(className), result);
    }
}

