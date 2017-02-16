package controller;

import dao.RoleDaoImplements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

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
public class RoleUpdateController extends HttpServlet {
    private static ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
    RoleDaoImplements rdi = (RoleDaoImplements) beans.getBean("roleDaoImp");

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleName;
        String newRole;
        List<User> userList;

        if(req.getParameter("newRole") != null){
            roleName = req.getParameter("oldRole");
            newRole = req.getParameter("newRole");

            try {
                userList = rdi.findRole(roleName).getUserList();
                rdi.updateRole(roleName, newRole, userList);
                resp.sendRedirect("tableShow.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
