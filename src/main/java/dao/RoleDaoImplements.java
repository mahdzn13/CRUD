package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import conectorDB.ConnectionFactory;
import pojo.Role;
import pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 13/02/2017.
 */
public class RoleDaoImplements implements RoleDao {
    private Connection connection = (Connection) ConnectionFactory.getConnection();
    private PreparedStatement ps;

    //Get all the list of roles
    public List<Role> getAllRoles() throws SQLException {
        List<Role> roleList = new ArrayList<Role>();

        String sql = "SELECT * FROM dwes.roles";

        ps = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Role currentRol = new Role(rs.getString("roles.role_name"),rs.getString("roles.role_description") );
            roleList.add(currentRol);
        }
        return roleList;
    }

    public Role findRole(String roleName) throws SQLException {
        String sql = "SELECT user_roles.role_name,user_roles.user_name FROM user_roles WHERE user_roles.role_name=?";
        List<User> userList = new ArrayList<User>();

        ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, roleName);
        ResultSet rs = ps.executeQuery();

        roleName = "";
        while (rs.next()) {
            roleName = rs.getString("user_roles.role_name");
            userList.add(new User(rs.getString("user_roles.user_name")));
        }
        return new Role(roleName, userList);
    }


    //Inserts a rol
    public void insertRole(String roleName, String roleDesc) throws SQLException {
        String sql = "INSERT into dwes.roles SET role_name=?,role_description=?";
        ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, roleName);
        ps.setString(2, roleDesc);
        ps.execute();
    }

    //Updates a rol
    public void updateRole(String oldRole, String newRole, List<User> userList) throws SQLException {
        String sql = "DELETE FROM dwes.user_roles WHERE role_name=?";

        ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, oldRole);
        ps.execute();

        sql = "UPDATE dwes.roles SET role_name=? where roles.role_name=?";
        ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, newRole);
        ps.setString(2, oldRole);
        ps.execute();

        sql = "INSERT INTO dwes.user_roles SET user_name=?,role_name=?";
        for(User currentUser : userList) {
            ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setString(1,currentUser.getName());
            ps.setString(2,newRole );
            ps.execute();
        }
    }

    //Deletes a rol
    public void deleteRole(String roleName) throws SQLException {
        String sql = "DELETE FROM dwes.user_roles WHERE role_name=?";
        ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, roleName);
        ps.execute();

        sql = "DELETE FROM dwes.roles WHERE role_name=?";
        ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, roleName);
        ps.execute();
    }

}
