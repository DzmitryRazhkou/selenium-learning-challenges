package challenges.interview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DisableImages {

    @Test
    public void loadDisabledImages() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        disableImageChrome(options);
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.yahoo.com/");
        System.out.println(driver.getTitle());

        Thread.sleep(3000);
        driver.quit();
    }

    public static void disableImageChrome(ChromeOptions options){
        HashMap<String, Object> images = new HashMap<>();
        images.put("images", 2);
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values", images);
        options.setExperimentalOption("prefs", prefs);
    }
}
