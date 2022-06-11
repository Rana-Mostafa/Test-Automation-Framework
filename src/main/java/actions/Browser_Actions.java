package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.HashMap;
import java.util.Map;

public class Browser_Actions {
    public static Map <String , WebDriver > drivers = new HashMap<>();
    public  Browser_Actions (String className , String browser, boolean headless)
    {
        if(headless==true)
        {

        }
        else {
            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                    drivers.put(className, new ChromeDriver());
                    break;

                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                    drivers.put(className, new FirefoxDriver());
                    break;

                case "edge":
                    System.setProperty("webdriver.edge.driver.", "drivers/msedgedriver.exe");
                    drivers.put(className, new EdgeDriver());
                    break;
            }
        }
    }

    public void navigateURL (String className , String URL)
    {
        drivers.get(className).get(URL);
    }

    public void maximizeWindow (String className)
    {
        drivers.get(className).manage().window().maximize();
    }

    public void minimizeWindow (String className)
    {
        drivers.get(className).manage().window().minimize();
    }

    public void fullscreenWindow (String className)
    {
        drivers.get(className).manage().window().fullscreen();
    }

    public void switchToWindow (String className)
    {
        drivers.get(className);
    }

    public void CloseDriver (String className)
    {
        drivers.get(className).close();
        drivers.remove(className);
    }

    public void endSession (String className)
    {
        drivers.get(className).quit();
        drivers.remove(className);
    }


}
