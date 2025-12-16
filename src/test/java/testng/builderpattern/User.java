package testng.builderpattern;

public class User {

    private String username;
    private String psw;
    private String role;

    private User(UserBuilder userBuilder) {
        this.username = userBuilder.username;
        this.psw = userBuilder.psw;
        this.role = userBuilder.role;
    }

    public String getRole() {
        return role;
    }

    public static class UserBuilder {

        private String username;
        private String psw;
        private String role;

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setPsw(String psw) {
            this.psw = psw;
            return this;
        }

        public UserBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
