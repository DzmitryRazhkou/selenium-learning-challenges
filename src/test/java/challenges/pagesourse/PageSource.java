package challenges.pagesourse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PageSource {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://charter97.org/");
        System.out.println(" =====> " + driver.getTitle() + " <===== ");

        String pageSource = driver.getPageSource();
        assert pageSource != null;
        Assert.assertTrue(pageSource.contains("Хартия'97"));
        Thread.sleep(2000);

        driver.close();
        driver.quit();
    }
}
