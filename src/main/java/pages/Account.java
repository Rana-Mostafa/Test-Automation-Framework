package pages;

import actions.UI_Actions;
import org.openqa.selenium.WebDriver;

public class Account extends BasePage{

    String className;
    public Account(String className){
        super(className);
        this.className=className;
    }
    @Deprecated
    public boolean getLoginStatus() {
        return ui_action.isElementPresent("//a[@class=\"ico-logout\"]", UI_Actions.Locators.XPath,3000);
    }

    public void logOut() {
        ui_action.clickOn("//a[@class=\"ico-logout\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.ElementToBeClickable);
    }
}
