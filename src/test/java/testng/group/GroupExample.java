package testng.group;

import org.testng.annotations.Test;

public class GroupExample {

    @Test(groups = "smoke")
    public void smokeTest() {
        // Quick sanity test
        System.out.println("Smoke Test");
    }

    @Test(groups = "regression")
    public void regressionTest() {
        // Full regression test
        System.out.println("Regression Test");
    }
}
