package pages;

import actions.UI_Actions;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage{

    String className;
    public Login(String className){
        super(className);
        this.className=className;
    }

    public Account loginUser(String email, String password) {
        ui_action.sendKeys("//input[@id=\"Email\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.ElementToBeClickable,email);
        ui_action.sendKeys("//input[@id=\"Password\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.ElementToBeClickable,password);
        ui_action.clickOn("//button[contains(@class,\"login-button\")]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.ElementToBeClickable);
        return new Account(className);
    }

    public SignIn clickOnSignIn(String xpath) {
        ui_action.clickOn("//button[contains(@class,\"register-button\")]", UI_Actions.Locators.XPath,5,null);
        return new SignIn(className);
    }


}
