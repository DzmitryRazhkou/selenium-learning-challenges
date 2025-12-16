package testng.retrylogic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;

public class Base {

    static WebDriver driver;

    public static void initialization() {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.get("http://google.com");
    }

    public void failed(String testMethodName) {

        String path = "/Users/dzmitryrazhkou/Documents/TestPro/Practise_Automation/src/test/java/TestNG/screenShot/Failed/";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(path + testMethodName + "_" + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
