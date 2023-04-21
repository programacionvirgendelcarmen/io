package teoria.json;

import java.util.Arrays;
import java.util.List;

public class User {
    private String name;
    private String email;
    private List<String> roles;
    private boolean admin;

    public User(String name, String email, List<String> roles, boolean admin) {
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%B",
                name, email, roles, admin);
    }
}
