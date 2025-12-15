package challenges.interview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowOutOfHundredWindowsAndValidate {

    public WebDriver driver;

    @Test
    public void handleHundredWindows() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String URL = "https://opensource-demo.orangehrmlive.com/";   // Parent Window
        String parentWindowId = driver.getWindowHandle();

        driver.get(URL);
        driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']//a)[1]")).click();
        driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']//a)[2]")).click();
        driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']//a)[3]")).click();
        driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']//a)[4]")).click();

        Set<String> handles = driver.getWindowHandles();
        List<String> hList = new ArrayList<String>(handles);
        if (switchToRightWindow("OrangeHRM Inc", hList)) {
            System.out.println(driver.getCurrentUrl() + ": " + driver.getTitle());
        }

        closeAllWindow(hList, parentWindowId);
        switchToParentWindow(parentWindowId);
        System.out.println(driver.getCurrentUrl() + ": " + driver.getTitle());

        driver.close();
    }


    // Methods:
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String e : hList) {
            String title = driver.switchTo().window(e).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right Window");
                return true;
            }
        }
        return false;
    }

    public void closeAllWindow(List<String> hList, String parentWindowId) {
        for (String e : hList) {
            if (!e.equals(parentWindowId)) {
                driver.switchTo().window(e).close();
            }
        }
    }
}
