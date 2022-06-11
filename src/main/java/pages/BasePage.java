package pages;

import actions.Browser_Actions;
import actions.UI_Actions;
import actions.Wait;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected Wait wait;
    protected UI_Actions ui_action;


    public BasePage(String className)
    {
        this.driver = Browser_Actions.drivers.get(className);
        wait = new Wait();
        ui_action = new UI_Actions(driver);
    }
}
