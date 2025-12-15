package challenges.windowsdimensions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowsDimensions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        Dimension d = new Dimension(75, 25);
        driver.manage().window().setSize(d);

        driver.get("https://www.chipotle.com/");

        System.out.println("The Title Page is: " + driver.getTitle());
        Thread.sleep(3000);
        driver.quit();
    }
}
