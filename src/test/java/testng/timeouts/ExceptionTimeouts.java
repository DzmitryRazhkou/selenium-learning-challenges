package testng.timeouts;

import org.testng.annotations.Test;

public class ExceptionTimeouts {

    @Test(timeOut = 5000, expectedExceptions = NumberFormatException.class, invocationCount = 5)
    public void handleTimeouts() {
        Integer.parseInt("abc"); // throws NumberFormatException
    }

}
