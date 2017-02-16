package controller;

import dao.RoleDaoImplements;
import dao.UserDaoImplements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Marco on 15/02/2017.
 */
public class UserUpdateController extends HttpServlet{
    private static ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
    UserDaoImplements udi = (UserDaoImplements) beans.getBean("userDaoImp");


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName;
        String newName;
        List<Role> roles;

        if (req.getParameter("newName") != null){
            userName = req.getParameter("oldName");
            newName = req.getParameter("newName");

            try {
                roles = udi.findUser(userName, true).getRoles();
                udi.updateUser(userName, newName, roles);
                resp.sendRedirect("tableShow.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
