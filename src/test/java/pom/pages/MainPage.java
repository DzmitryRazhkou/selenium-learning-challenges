package challenges.pom.pages;

import pom.locators.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getMainBtn() {
        By mainBtnField = Locators.mainBtnLocator;
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainBtnField));
        return driver.findElement(mainBtnField);
    }

    public boolean isMainPage() {
        try {
            return getMainBtn().isDisplayed();
        } catch (TimeoutException mistake) {
            return false;
        }
    }

}
