package pages;

import actions.UI_Actions;
import org.openqa.selenium.WebDriver;
import static actions.UI_Actions.*;
public class Home extends BasePage{
    String className;
    public Home(String className){
        super(className);
        this.className=className;
    }

    @Deprecated
    public SignIn clickOnSignIn() {
        wait.waitUntil(driver,  ExpectedConditionsEnum.presenceOfElement, "//a[(@class=\"ico-register\")]",Locators.XPath,5);
        ui_action.clickOn("//a[(@class=\"ico-register\")]",Locators.XPath,5,null);
        return new SignIn(className);
    }

    @Deprecated
    public Login clickOnLogin() {
        wait.waitUntil(driver,  ExpectedConditionsEnum.presenceOfElement, "//a[(@class=\"ico-register\")]",Locators.XPath,5);
        ui_action.clickOn("//a[(@class=\"ico-login\")]",Locators.XPath,5,null);
        return new Login(className);
    }
}
