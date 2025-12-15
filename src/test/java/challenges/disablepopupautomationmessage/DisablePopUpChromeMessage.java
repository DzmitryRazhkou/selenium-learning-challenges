package challenges.disablepopupautomationmessage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DisablePopUpChromeMessage {
    @Test
    public void handlePopUpChromeMessage() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));

        // Remove sign "Thus application is being under automation":
        // opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        // Block all pop-ups windows while a website is loading:

        Thread.sleep(2000);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://charter97.org/");
        driver.quit();
    }
}
