package challenges.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsPresentExpectedCondition {
    @Test
    public void handleAlertIsPresentExpected() {

        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement clickForJSAlertButton = driver.findElement(By.xpath("//*[contains(text(), 'Click for JS Alert')]"));
        clickForJSAlertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertNotNull(alert);
        System.out.println(" =====> "+alert.getText()+" <==== ");
        Assert.assertNotNull(alert);
        alert.accept();

        driver.quit();
    }
}
