package testng.softassertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HandleSoftAssertion {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void handleSoftAssertion() {

        System.out.println("Open Browser");
        Assert.assertEquals(true, true);

        // Hard Assertion: hard validation: if a test assertion is getting failed --->
        // Immediately test case will be marked as failed and will be terminated.

        // Soft Assertion: soft validation: if a test assertion is getting failed --->
        // test case will not be marked as failed and the next lines will be executed.

        System.out.println("Enter Username");
        System.out.println("Enter Password");
        System.out.println("Click on the Sign in Button");
        System.out.println("Validate Home Page");

        softAssert.assertEquals(true, false); // Soft Assertion ---> will be executed

        System.out.println("Go to Deals Page");
        System.out.println("Create a Deal");
        softAssert.assertEquals(true, false);

        System.out.println("Go to Contacts Page");

        softAssert.assertAll(); // We can make a soft assert for all assertion in the class, but show you all errors.
    }
}
