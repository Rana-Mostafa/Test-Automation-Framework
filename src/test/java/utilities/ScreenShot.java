package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenShot  {
    public static void takeScreenShot(WebDriver driver, ITestResult result) throws IOException {

        if(ITestResult.FAILURE == result.getStatus())
        {
            //Create screenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,new File("./screenshots/Failuers/"+result.getName()+".png"));
        }

        else
        {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,new File("./screenshots/Successes/"+result.getName()+".png"));
        }


    }
}
