package challenges.interview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Calendar {

    public WebDriver driver;

    @Test
    public void handleCalendar() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        driver.findElement(By.id("datepicker")).click();
        new WebDriverWait(driver, Duration.ofMillis(500)).until(ExpectedConditions.visibilityOfElementLocated((By.className("ui-datepicker-calendar"))));

        String month_YearVariable = driver.findElement(By.className("ui-datepicker-title")).getText();
        System.out.println(month_YearVariable);

        String month = month_YearVariable.split(" ")[0].trim();
        String year = month_YearVariable.split("")[1].trim();

        while (!(month.equals("May") && year.equals("2023"))) {
            driver.findElement(By.xpath("//*[@title='Next']")).click();
            month_YearVariable = driver.findElement(By.className("ui-datepicker-title")).getText();
            System.out.println(month_YearVariable);

            month = month_YearVariable.split(" ")[0].trim();
            year = month_YearVariable.split(" ")[1].trim();
        }

        driver.findElement(By.xpath("//a[text()='28']")).click();
    }
}
