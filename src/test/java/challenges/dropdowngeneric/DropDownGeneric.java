package challenges.dropdowngeneric;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownGeneric {

    static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

        By country = By.id("Form_submitForm_Country");

//        Select select1 = new Select(driver.findElement(By.id("Form_submitForm_Country")));
//        select.selectByVisibleText("Belarus");

//        doSelectByVisibleText(country, "Belarus");

        selectDropDownValue(country, "index", "9");
    }

    public static void selectDropDownValue(By locator, String type, String value) {

        Select s = new Select(getElement(locator));

        switch (type) {
            case "index":
                s.selectByIndex(Integer.parseInt(value));
                break;

            case "value":
                s.selectByValue(value);
                break;

            case "visibleTest":
                s.selectByVisibleText(value);
                break;

            default:
                System.out.println("Pass the Correct Selection Criteria.... ");
                break;
        }

    }

    //  Separate Functions:

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void doSelectByVisibleText(By locator, String value) {
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(value);
    }

    public static void doSelectByIndex(By locator, int index) {
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }

    public static void doSelectByValue(By locator, String value) {
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }
}
