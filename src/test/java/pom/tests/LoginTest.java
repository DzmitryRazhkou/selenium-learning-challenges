package pom.tests;

import pom.pages.LoginPage;
import pom.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginToWeb_CorrectCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.logToWebSite(email, valid_password);

        Assert.assertTrue(mainPage.isMainPage());
    }

    @Test
    public void LoginToWeb_IncorrectCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.logToWebSite(email, wrong_password);

        Assert.assertTrue(loginPage.isError());
    }

    @Test
    public void LoginToWeb_CorrectCredentials_1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.logToWebSite(email, valid_password);

        Assert.assertTrue(mainPage.isMainPage());
    }

    @Test
    public void LoginToWeb_IncorrectCredentials_1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.logToWebSite(email, wrong_password);

        Assert.assertTrue(loginPage.isError());
    }

    @Test
    public void LoginToWeb_CorrectCredentials_2() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.logToWebSite(email, valid_password);

        Assert.assertTrue(mainPage.isMainPage());
    }

    @Test
    public void LoginToWeb_IncorrectCredentials_2() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.logToWebSite(email, wrong_password);

        Assert.assertTrue(loginPage.isError());
    }

    @Test
    public void LoginToWeb_CorrectCredentials_3() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.logToWebSite(email, valid_password);

        Assert.assertTrue(mainPage.isMainPage());
    }

    @Test
    public void LoginToWeb_IncorrectCredentials_3() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.logToWebSite(email, wrong_password);

        Assert.assertTrue(loginPage.isError());
    }
}



