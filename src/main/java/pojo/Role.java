package pojo;

import java.util.List;

public class Role {
    private String roleName;
    private String roleDesc;
    private List<User> userList;


    public Role(String roleName, String roleDesc) {
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }
    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleName, List<User> userList) {
        this.roleName = roleName;
        this.userList = userList;
    }
    public Role() {
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
