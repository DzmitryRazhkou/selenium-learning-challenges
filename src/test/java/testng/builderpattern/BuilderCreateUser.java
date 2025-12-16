package testng.builderpattern;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BuilderCreateUser {

    @Test
    public void createAdminUserTest() {

        User admin = new User.UserBuilder()
                .setUsername("admin")
                .setPsw("admin666")
                .setRole("ADMIN")
                .build();

        Assert.assertEquals(admin.getRole(), "ADMIN");
    }
}
