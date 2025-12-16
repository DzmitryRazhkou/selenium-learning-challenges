package testng.invocationcount;

import org.testng.annotations.Test;

public class HandleInvocationCount {

    @Test(invocationCount = 50)
    public void sum() {
        int a = 15;
        int b = 31;
        int c = a + b;

        System.out.println("Sum is: " + c);
    }
}
