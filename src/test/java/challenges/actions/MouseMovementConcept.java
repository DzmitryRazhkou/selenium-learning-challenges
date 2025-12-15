package challenges.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseMovementConcept {

    public static WebDriver driver;

    @Test
    public void handleKeyboardsActions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String URL = "https://www.spicejet.com";
        driver.get(URL);

        Actions actions = new Actions(driver);
        WebElement addOns = driver.findElement(By.xpath("//*[text()='Add-ons']"));
        actions.moveToElement(addOns).build().perform();

        Thread.sleep(1500);
        System.out.println("Completed");
        driver.close();
    }
}
