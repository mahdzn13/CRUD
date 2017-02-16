package pojo;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String password;
    private List<Role> roles = new ArrayList<Role>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User(String name,List<Role> roleList) {
        this.roles = roleList;
        this.name = name;
    }
    public User(String name) {
        this.name = name;
    }
    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
