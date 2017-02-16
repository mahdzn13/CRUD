package dao;

import pojo.Role;
import pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface RoleDao {
    public List<Role> getAllRoles() throws SQLException;
    Role findRole(String roleName) throws SQLException;
    public void insertRole(String roleName, String roleDesc) throws SQLException;
    public void updateRole(String oldRole, String newRole, List<User> userList) throws SQLException;
    public void deleteRole(String roleName) throws SQLException;
}
