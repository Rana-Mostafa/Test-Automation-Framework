package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.util.List;

public class UI_Actions {
    WebDriver driver;
    Wait wait;
    public UI_Actions (WebDriver driver)
    {
        this.driver=driver;
        wait=new Wait();
    }

    public WebElement findElement (Locators locator, String Path)
    {
        switch (locator)
        {
            case XPath:
                return driver.findElement(By.xpath(Path));
            case id:
                return driver.findElement(By.id(Path));
            case CSS:
                return driver.findElement(By.cssSelector(Path));
            case Class:
                return driver.findElement(By.className(Path));
            case tag:
                return driver.findElement(By.tagName(Path));
        }
        return null;
    }

    public List<WebElement> findElements (Locators locator, String Path)
    {
        switch (locator)
        {
            case XPath:
                return driver.findElements(By.xpath(Path));
            case id:
                return driver.findElements(By.id(Path));
            case CSS:
                return driver.findElements(By.cssSelector(Path));
            case Class:
                return driver.findElements(By.className(Path));
            case tag:
                return driver.findElements(By.tagName(Path));
        }
        return null;
    }

    public void clickOn (String Path, Locators locator, int time, ExpectedConditionsEnum cond)
    {
        WebElement element = findElement(locator,Path);
        element.click();
    }

    public void sendKeys (String Path, Locators locator, int time, ExpectedConditionsEnum cond,String text)
    {
        WebElement element = findElement(locator,Path);
        element.sendKeys(text);
    }

    public void ClearSendKeys (String Path, Locators locator, int time, ExpectedConditionsEnum cond,String text)
    {
        WebElement element = findElement(locator,Path);
        element.clear();
        element.sendKeys(text);
    }

    public String getText (String Path, Locators locator, int time, ExpectedConditionsEnum cond)
    {
        WebElement element = findElement(locator,Path);
        return element.getText();
    }

    public void SelectDropDownListByVal (String Path, Locators locator, int time, ExpectedConditionsEnum cond,String Value)
    {
        WebElement element = findElement(locator,Path);
        Select select = new Select(element);
        select.selectByValue(Value);
    }

    public void SelectDropDownListByIndex (String Path, Locators locator, int time, ExpectedConditionsEnum cond,int index)
    {
        WebElement element = findElement(locator,Path);
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void SelectDropDownListByText (String Path, Locators locator, int time, ExpectedConditionsEnum cond,String text)
    {
        WebElement element = findElement(locator,Path);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void mouseActions(MouseAction action, String Path, Locators locator, int time, ExpectedConditionsEnum cond) {
        Actions builder = new Actions(driver);
        WebElement element = findElement(locator,Path);
        switch (action) {
            case Hover:
                builder.moveToElement(element).build().perform();
                break;
            case DoubleClick:
                builder.doubleClick(element).build().perform();
                break;
            case RightClick:
                builder.contextClick(element).build().perform();
                break;
        }
    }

    public void ScrollDown ()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,5000)");
    }

    @Deprecated
    public boolean isElementPresent(String Path, Locators locator, int time) {
        try {
            wait.waitUntil(driver,ExpectedConditionsEnum.presenceOfElement,Path,locator,time);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public enum MouseAction
    {
        Hover,
        DoubleClick,
        RightClick
    }

    public enum Locators
    {
        XPath,
        CSS,
        id,
        Class,
        tag
    }

    public enum ExpectedConditionsEnum
    {
        presenceOfElement,
        ElementToBeClickable,
        Visible,
        PageLoad
    }
}
