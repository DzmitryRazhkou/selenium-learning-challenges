package challenges.signature;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleSignature {
    @Test
    public void handleSignature() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String URL = "https://www.signwell.com/online-signature/draw/";
        driver.get(URL);

        Thread.sleep(1500);

        WebElement signatureCanvas = driver.findElement(By.id("signature_surface"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(signatureCanvas, 250, 90).build().perform();

        Thread.sleep(1500);
        driver.quit();
    }
}
