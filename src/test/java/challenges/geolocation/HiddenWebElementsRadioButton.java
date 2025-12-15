package challenges.geolocation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HiddenWebElementsRadioButton {

    protected WebDriver driver;

    @Test
    public void handleRadioButtonLocation() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3));

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");

        List<WebElement> radio = driver.findElements(By.id("male"));
        int count = radio.size();
        System.out.println(" =====> Total Radio Buttons: " + count + " <===== ");

        for (int i = 0; i < count; i++) {
            WebElement element = radio.get(i);
            int x = element.getLocation().getX();

            if (x != 0) {
                element.click();
                break;
            }
        }

        driver.close();
        driver.quit();
    }

}
