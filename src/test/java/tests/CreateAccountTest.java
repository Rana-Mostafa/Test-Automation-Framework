package tests;

import actions.Browser_Actions;
import actions.UI_Actions;
import actions.Wait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Home;
import pages.SignIn;
import utilities.DataProviderC;
import utilities.ScreenShot;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class CreateAccountTest {
    Browser_Actions bAction;
    Home homePage;
    SignIn signinPage;
    Wait wait;
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
    @Test(dataProvider = "RegisterFunction", dataProviderClass = DataProviderC.class)
    public void CreateValidAccount (String gender, String firstName, String lastName,
                                    String day, String month, String year, String email, String password)  {
        homePage = new Home(className);
        signinPage = homePage.clickOnSignIn();
        signinPage.registerUser(gender, firstName, lastName, day, month, year, email, password);
        assertEquals(signinPage.getRegistrationStatus(), "Your registration completed");
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
