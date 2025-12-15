package challenges;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HowToHandleChatBot {
    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String URL = "https://classic.freecrm.com/index.html";

        driver.get(URL);   // Enter URL

        driver.switchTo().frame("intercom-borderless-frame");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@class='intercom-1izpp5p e1dst0fh3']"))).build().perform();
        driver.findElement(By.xpath("//*[@class='intercom-jziayb e13xul2n4']")).click();

    }
}
