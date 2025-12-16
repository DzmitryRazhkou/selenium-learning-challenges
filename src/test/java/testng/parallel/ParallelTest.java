package testng.parallel;

import org.testng.annotations.Test;

public class ParallelTest {

    @Test(groups = "smoke")
    public void test1() {
        // Executed in parallel thread
        System.out.println("Test 1 - Thread: " + Thread.currentThread().getId());
    }

    @Test(groups = "smoke")
    public void test2() {
        // Executed in parallel thread
        System.out.println("Test 2 - Thread: " + Thread.currentThread().getId());
    }

    @Test(groups = "smoke")
    public void test3() {
        // Executed in parallel thread
        System.out.println("Test 3 - Thread: " + Thread.currentThread().getId());
    }
}
