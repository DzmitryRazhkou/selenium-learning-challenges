package challenges.propertiesfile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class PropertiesTest {

    @Test
    public void handleProperties() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));

        String url = PropertyFileUtils.loadApplicationProperties().getProperty("app_url");
        driver.get(url);

        Assert.assertTrue(driver.getTitle().equals("Google"), "Page title isn't correct");
        driver.quit();
    }
}
