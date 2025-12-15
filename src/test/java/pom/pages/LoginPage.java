package challenges.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.locators.Locators;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getEmailField() {
        By emailField = Locators.emailLocator;
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        return driver.findElement(emailField);
    }

    private WebElement getPasswordField() {
        By passwordField = Locators.passwordLocator;
        return driver.findElement(passwordField);
    }

    private WebElement getLoginButton() {
        By loginButton = Locators.loginBtnLocator;
        return driver.findElement(loginButton);
    }

    public void open() {
        String url = "https://www.pinterest.com/login/";
        driver.get(url);
    }

    public MainPage logToWebSite(String email, String password) {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);
    }

    private WebElement getErrorMessage() {
        By error = Locators.errorBtnLocator;
        wait.until(ExpectedConditions.visibilityOfElementLocated(error));
        return driver.findElement(error);
    }

    public boolean isError() {
        try {
            return getErrorMessage().isDisplayed();
        } catch (TimeoutException err) {
            return false;
        }
    }
}
