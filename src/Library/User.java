package Library;

import java.util.Arrays;
import java.util.List;

public class User {

    // data fields
    private String name;
    private String userId;
    private String password;
    private String role;

    // accepted roles
    private static final List<String> VALID_ROLES = Arrays.asList("Admin", "Member");

    // constructor function
    public User(String name, String userId, String password, String role) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        setRole(role);
    }

    // getter and setter functions
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (VALID_ROLES.contains(role)) {
            this.role = role;
        } else {
            throw new IllegalArgumentException("Invalid role, use 'Admin' or 'Member'.");
        }
    }

    @Override
    public String toString() {
        return name + "," + userId + "," + password + "," + role;
    }

    // Convert a comma-separated string back to a User object
    public static User fromString(String userString) {
        String[] parts = userString.split(",");

        // basic validation
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid user format");
        }
        return new User(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
    }
}