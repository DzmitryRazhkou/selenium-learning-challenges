package testng.timeouts;

import org.testng.annotations.Test;

public class HandleArithmeticException {

    @Test(expectedExceptions = ArithmeticException.class)
    public void exc(){
        int y = 9;
        int z = 9/0;
        System.out.println("Result is: " +z);
    }

}
