package challenges.bootstrapdropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class BootStrapDropDown {

    @Test
    public void handleDropDown() throws InterruptedException {

        String value = selectRandom();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Dynamic Wait:
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Load Web Page URL:
        driver.get("https://jqueryui.com/selectmenu/");

        WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement lastProgrammingLanguage = driver.findElement(By.cssSelector("#speed-button"));
        lastProgrammingLanguage.click();

        List<WebElement> arrayOfProgrammingLanguage = driver.findElements(By.cssSelector("#speed-menu>li"));
        for (WebElement s: arrayOfProgrammingLanguage) {
            if (s.getText().contains(value)) {
                s.click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.close();
        driver.quit();
    }

    public static String selectRandom() {
        List<String> list = new ArrayList<>(List.of("Slower", "Slow", "Medium", "Fast", "Faster"));
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
