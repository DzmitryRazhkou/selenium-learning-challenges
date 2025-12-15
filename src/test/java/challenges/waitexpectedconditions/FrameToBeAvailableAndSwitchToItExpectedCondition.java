package challenges.waitexpectedconditions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FrameToBeAvailableAndSwitchToItExpectedCondition {

    @Test
    public void handleElementToBeSelectedExpectedCondition() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://jqueryui.com/spinner/");

        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are " + iframeElements.size());
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");

        By frameLocator = By.xpath("//*[@class='demo-frame']");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));

        By elemSetValue = By.xpath("//*[contains(text(),'Get value')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(elemSetValue));

        driver.close();
        driver.quit();
    }
}
