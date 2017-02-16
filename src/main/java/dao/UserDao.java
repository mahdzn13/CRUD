package dao;

import pojo.Role;
import pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    User findUser(String userName) throws SQLException;
    User findUser(String name, boolean fillRoll) throws SQLException;
    void insertUser(String name,String password,String[] roles) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
    public void updateUser(String oldName,String name, List<Role> roles) throws SQLException;
    public void deleteUser(String name) throws SQLException;
}
