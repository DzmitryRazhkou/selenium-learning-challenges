package testng.annotions;

import org.testng.annotations.*;

public class AnnotationExample {

    @BeforeClass // Runs once before any test method in this class
    public void setup() {
        System.out.println(" ===>>>>> Before Class");
    }

    @BeforeMethod // Runs before each @Test method
    public void beforeMethod() {
        System.out.println(" >>>>> --- Before Method");
    }

    @Test
    public void testCase1() {
        System.out.println("Test Case #1");
    }

    @Test
    public void testCase2() {
        System.out.println("Test Case #2");
    }

    @AfterMethod // Runs after each @Test method
    public void afterMethod() {
        System.out.println(" =====<<<<< After Method");
    }

    @AfterClass // Runs once after all test methods
    public void tearDown() {
        System.out.println(" <<<<< --- After Class");
    }
}
