package pages;

import actions.UI_Actions;
import org.openqa.selenium.WebDriver;

import java.util.Locale;


public class SignIn extends BasePage{

    String className;
    public SignIn(String className){
        super(className);
        this.className=className;
    }

    public void registerUser(String gender,String firstname, String lastname,
                             String day, String month, String year, String email, String password) {

        if (gender.equals("male"))
            ui_action.clickOn("//input[@id=\"gender-male\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.ElementToBeClickable);
        else
            ui_action.clickOn("//input[@id=\"gender-female\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.ElementToBeClickable);

        ui_action.sendKeys("//input[@id=\"FirstName\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.Visible,firstname);
        ui_action.sendKeys("//input[@id=\"LastName\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.Visible,lastname);

        ui_action.SelectDropDownListByText("//select[@name=\"DateOfBirthDay\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.presenceOfElement,day);
        ui_action.SelectDropDownListByVal("//select[@name=\"DateOfBirthMonth\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.presenceOfElement,month);
        ui_action.SelectDropDownListByText("//select[@name=\"DateOfBirthYear\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.presenceOfElement,year);

        ui_action.sendKeys("//input[@id=\"Email\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.ElementToBeClickable,email);
        ui_action.sendKeys("//input[@id=\"Password\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.ElementToBeClickable,password);
        ui_action.sendKeys("//input[@id=\"ConfirmPassword\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.ElementToBeClickable,password);
        ui_action.clickOn("//button[@id=\"register-button\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.ElementToBeClickable);
    }

    @Deprecated
    public String getRegistrationStatus() {
        wait.waitUntil(driver, UI_Actions.ExpectedConditionsEnum.presenceOfElement,"//div[@class=\"result\"]", UI_Actions.Locators.XPath, 3000);
        return ui_action.getText("//div[@class=\"result\"]", UI_Actions.Locators.XPath, 3000, UI_Actions.ExpectedConditionsEnum.Visible);
    }


}
