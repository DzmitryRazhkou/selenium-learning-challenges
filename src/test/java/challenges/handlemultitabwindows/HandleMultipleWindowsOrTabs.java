package challenges.handlemultitabwindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class HandleMultipleWindowsOrTabs {
    @Test
    public void handleMultipleWindowsOrTabs() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        driver.get("https://charter97.org/");
        System.out.println(" =====> " + driver.getTitle() + " <===== ");

        String currentPage = driver.getWindowHandle();

        By youtubeLinkLocator = By.xpath("//a[@href='https://www.youtube.com/user/Charter97video']");
        wait.until(ExpectedConditions.elementToBeClickable(youtubeLinkLocator));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(youtubeLinkLocator));
        driver.findElement(youtubeLinkLocator).click();

        Set<String> pages = driver.getWindowHandles();
        System.out.println("The Amount Of The Page Is: " + pages.size());

        for (String s : pages) {
            if (!currentPage.equalsIgnoreCase(s)) {
                driver.switchTo().window(s);
            }
        }

        Thread.sleep(2000);

        System.out.println("Child window title is " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Charter97video - YouTube");

        Thread.sleep(2000);

        driver.close();
        driver.quit();
    }
}
