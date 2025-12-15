package challenges.pagesourse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class PageSourse {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        driver.get("https://charter97.org/");
        System.out.println(" =====> " + driver.getTitle() + " <===== ");

        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Хартия'97"));
        Thread.sleep(2000);

        driver.close();
        driver.quit();
    }
}
