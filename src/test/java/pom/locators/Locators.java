package pom.locators;

import org.openqa.selenium.By;

public class Locators {

    public static final By emailLocator = By.xpath("//*[@placeholder='Email']");
    public static final By passwordLocator = By.xpath("//*[@placeholder='Password']");
    public static final By loginBtnLocator = By.xpath("//*[text()='Log in']");
    public static final By mainBtnLocator = By.xpath("//*[text()='Главная']");
    public static final By errorBtnLocator = By.xpath("//*[@id='password-error']");

}
