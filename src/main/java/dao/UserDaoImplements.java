package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import conectorDB.ConnectionFactory;
import pojo.Role;
import pojo.User;

import javax.management.relation.RoleStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImplements implements UserDao {
    private Connection connection = (Connection) ConnectionFactory.getConnection();
    private PreparedStatement ps;

    public UserDaoImplements() {
    }


    public User findUser(String userName) throws SQLException {
        User user = null;

        String sql = "SELECT users.user_name FROM dwes.users WHERE users.user_name=?";

        ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
           user = new User(rs.getString("users.user_name"));
        }

        return user;
    }

    public User findUser(String userName, boolean fillRoll) throws SQLException {
        if(fillRoll){
            String user = "";
            List<Role> roleList = new ArrayList<Role>();

            String sql = "SELECT user_roles.user_name,user_roles.role_name FROM dwes.user_roles WHERE user_roles.user_name=?";

            ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user = rs.getString("user_roles.user_name");
                roleList.add(new Role(rs.getString("user_roles.role_name")));
            }

            return new User(user,roleList);
        } else {
            return findUser(userName);
        }
    }

    public void insertUser(String name, String password, String[] roles) throws SQLException {
        String sql = "INSERT INTO dwes.users SET user_name=?,user_pass=?";
        ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, password);
        ps.execute();

        sql = "INSERT INTO user_roles SET user_name=?,role_name=?";
        for (int i = 0; i < roles.length; i++) {
            ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, roles[i]);
            ps.execute();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> usersList = new ArrayList<User>();

        String sql = "SELECT * FROM dwes.users";

        ps = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
           usersList.add(new User(rs.getString("users.user_name")));
        }

        return usersList;
    }

    public void updateUser(String oldName, String name, List<Role> roles) throws SQLException {
        String sql = "DELETE FROM dwes.user_roles WHERE user_name=?";
        ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, oldName);
        ps.execute();

        sql = "UPDATE dwes.users SET user_name=? WHERE users.user_name=?";
        ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, oldName);
        ps.execute();

        sql = "INSERT INTO dwes.user_roles SET user_roles.user_name=?,role_name=? ";
        for (Role currentRole : roles) {
            ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, currentRole.getRoleName());
            ps.execute();
        }


    }

    public void deleteUser(String name) throws SQLException {
        String sql = "DELETE FROM dwes.user_roles WHERE user_name=?";
        ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, name);
        ps.execute();

        sql = "DELETE FROM dwes.users WHERE user_name=?";
        ps = (PreparedStatement) connection.prepareStatement(sql);
        ps.setString(1, name);
        ps.execute();
    }
}
