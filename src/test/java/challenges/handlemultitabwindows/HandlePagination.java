package challenges.handlemultitabwindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HandlePagination {

    @Test
    public void handlePagination() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://datatables.net/examples/advanced_init/dt_events.html";
        driver.get(url);

        int paginationSize = driver.findElements(By.cssSelector("#example_paginate >span>a")).size();    //   Number of Pages

        List<String> names = new ArrayList<>();    // ArrayList for WebElements

        for (int i = 1; i <= paginationSize; i++) {

            String paginationSelector = "#example_paginate >span>a:nth-child("+i+")";    // Selector for pagination (1, 2, 2, 4, 5, 6)
            driver.findElement(By.cssSelector(paginationSelector)).click();

            List<WebElement> namesElements = driver.findElements(By.cssSelector("#example >tbody >tr >td:nth-child(3)"));

//          List webElements (column of Names)

            for (WebElement namesEl: namesElements) {
                names.add(namesEl.getText());
            }
        }

//        Sort and add to ArrayList "names".

        for (String n : names) {
            System.out.println(n);
        }

        int totalNames = names.size();
        System.out.println("Total Number: " + totalNames);

        String displayedCount = driver.findElement(By.id("example_info")).getText().split(" ")[5];
        System.out.println("Total Number of Displayed: " +displayedCount);

        Assert.assertEquals(displayedCount, String.valueOf(totalNames));

        Thread.sleep(1500);
        driver.quit();
    }
}
