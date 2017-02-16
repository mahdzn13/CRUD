package controller;

import dao.UserDaoImplements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserShowAllController extends HttpServlet{
    private static ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
    UserDaoImplements udi = (UserDaoImplements) beans.getBean("userDaoImp");

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = new ArrayList<User>();
        try {
            userList = udi.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("tableShow.jsp").forward(req, resp);
    }
}
