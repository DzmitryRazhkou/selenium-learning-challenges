package challenges.waitexpectedconditions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HoverMouse {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Test
    public void handleMoveToElement() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        driver.manage().window().maximize();

        driver.get("https://www.ebay.com");
        Actions actions = new Actions(driver);

        WebElement electronicBtn = driver.findElement(By.linkText("Electronics"));
        wait.until(ExpectedConditions.elementToBeClickable(electronicBtn));
        actions.moveToElement(electronicBtn).build().perform();

        WebElement iphone = driver.findElement(By.linkText("iPhones"));
        wait.until(ExpectedConditions.elementToBeClickable(iphone));

        actions.moveToElement(iphone).build().perform();
        iphone.click();

        driver.close();
        driver.quit();
    }
}
