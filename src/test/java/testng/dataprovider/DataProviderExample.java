package testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][]{{"admin", "admin666"}, {"user", "user666"}, {"agent", "agent666"}};
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        System.out.println("Username: " + username + " Password: " + password);
    }

}
