package challenges.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropDownLoop {

    public WebDriver driver;

    @Test
    public void handleDropDown() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Dynamic Wait:
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().minimize();
        driver.get("https://www.facebook.com/");

        // Locators:
        By createAccountButtonLocator = By.xpath("//*[@data-testid='open-registration-form-button']");
        By monthLocator = By.xpath("//select[@id='month']//option");
        By dayLocator = By.xpath("//select[@id='day']//option");
        By yearLocator = By.xpath("//select[@id='year']//option");

        // Actions:
        WebElement createAccountButton = driver.findElement(createAccountButtonLocator);
        createAccountButton.click();

        selectDropDownValue(monthLocator, "May");
        selectDropDownValue(dayLocator, "28");
        selectDropDownValue(yearLocator, "1990");

        Thread.sleep(1000);

        driver.close();
        driver.quit();
    }

    public void selectDropDownValue(By locator, String value) {
        List<WebElement> monthList = driver.findElements(locator);
        System.out.println("The Lis Of The Months Is: " + monthList.size());
        System.out.println("\n__________");

        for (WebElement webElement : monthList) {
            System.out.println(webElement.getText());
            if (webElement.getText().equalsIgnoreCase(value)) {
                webElement.click();
                break;
            }
        }
    }
}
