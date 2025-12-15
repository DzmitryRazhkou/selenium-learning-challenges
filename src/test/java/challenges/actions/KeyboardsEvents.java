package challenges.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleChatBot {
    public static WebDriver driver;

    @Test
    public void closeChatBot() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String URL = "https://classic.freecrm.com/index.html";
        driver.get(URL);

        driver.switchTo().frame("intercom-borderless-frame");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@class='intercom-1izpp5p e1dst0fh3']"))).build().perform();
        driver.findElement(By.xpath("//*[@class='intercom-jziayb e13xul2n4']")).click();
    }
}
