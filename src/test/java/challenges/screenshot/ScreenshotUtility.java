package challenges.screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

    public static void takeScreenshot(WebDriver driver, String methodName) {

        String path = "/Users/dzmitryrazhkou/Desktop/Screenshots";

        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(path));
        } catch (IOException err) {
            err.printStackTrace();
        }

        System.out.println("Exception While Taking Screenshot.");
    }

    public static String getScreenshotFileName(String methodName) {
        return methodName + "-" + new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date()) + ".png";
    }
}
