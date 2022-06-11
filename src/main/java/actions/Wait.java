package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Wait {
    public By getBy (UI_Actions.Locators locator, String Path)
    {
        switch (locator)
        {
            case XPath:
                return By.xpath(Path);
            case id:
                return By.id(Path);
            case CSS:
                return By.cssSelector(Path);
            case Class:
                return By.className(Path);
            case tag:
                return By.tagName(Path);
        }
        return null;
    }

    @Deprecated
    public void waitUntil (WebDriver driver, actions.UI_Actions.ExpectedConditionsEnum cond, String Path, UI_Actions.Locators locator, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        By by = getBy(locator,Path);
        switch (cond)
        {
            case presenceOfElement:
                try
                {
                    wait.until(ExpectedConditions.presenceOfElementLocated(by));
                }
                catch(Exception e)
                {
                    System.out.println("Element " + by.toString() + " is not present");
                }
                break;

            case ElementToBeClickable:
                try
                {
                    wait.until(ExpectedConditions.elementToBeClickable(by));
                }
                catch(Exception e)
                {
                    System.out.println("Element " + by.toString() + " is not clickable");
                }
                break;

            case Visible:
                try
                {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                }
                catch(Exception e)
                {
                    System.out.println("Element " + by.toString() + " is not visible");
                }
                break;

            case PageLoad:
                try
                {
                    wait.until(driver1->((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
                }
                catch(Exception e)
                {
                    System.out.println("Page not loaded yet");
                }
                break;

        }
    }

    @Deprecated
    public void waitUntilImplicit (WebDriver driver,  int time)
    {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
