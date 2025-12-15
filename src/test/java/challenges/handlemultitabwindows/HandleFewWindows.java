package challenges.handlemultitabwindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class HandleFewWindows {

    @Test
    public void handleFewWindows() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.pinterest.com/");
        WebElement loginButton = driver.findElement(By.xpath("//div[@data-test-id='simple-login-button']"));
        loginButton.click();

        Thread.sleep(2000);
        Set<String> handler = driver.getWindowHandles();
        Iterator<String> it = handler.iterator();

        String parentWindowId = it.next();
        System.out.println("Parent Window id: " + parentWindowId);

        String childWindowsId = it.next();
        System.out.println("Child Window id: " + parentWindowId);

        driver.switchTo().window(childWindowsId);
        Thread.sleep(2000);
        System.out.println("Child Window Pop Up " + driver.getTitle());
        driver.close();

        driver.switchTo().window(parentWindowId);
        Thread.sleep(2000);
        System.out.println("Parent Window Pop Up " + driver.getTitle());

        driver.close();
        driver.quit();
    }
}
