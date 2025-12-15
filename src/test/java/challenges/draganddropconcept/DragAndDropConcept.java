package challenges.draganddropconcept;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDropConcept {

    @Test
    public void handleDropDown() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Dynamic Wait:
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Load Web Page URL:
        driver.get("https://jqueryui.com/droppable/");   // Enter URL
        System.out.println("Page Has Loaded" + "\n_______________");

        driver.switchTo().frame(0);

        // Locators:
        By draggableLocator = By.xpath("//*[@id='draggable']");
        By droppableLocator = By.xpath("//*[@id='droppable']");

        actions.clickAndHold(driver.findElement(draggableLocator)).moveToElement(driver.findElement(droppableLocator)).release().build().perform();

        Thread.sleep(2000);

        driver.close();
        driver.quit();
    }

}
