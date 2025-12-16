package testng.dependency;

import org.testng.annotations.Test;

public class DependencyExample {

    @Test
    public void login() {
        // Login must pass before dashboard test
        System.out.println("Login Successful");
    }

    @Test(dependsOnMethods = "login")
    public void dashboard() {
        // Runs only if login() passes
        System.out.println("Dashboard Loaded");
    }
}
