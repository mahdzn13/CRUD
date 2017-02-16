package controller;

import dao.RoleDaoImplements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Role;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 15/02/2017.
 */
public class RoleShowAllController extends HttpServlet {
    private static ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
    RoleDaoImplements rdi = (RoleDaoImplements) beans.getBean("roleDaoImp");

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> roleList = new ArrayList<Role>();
        try {
            roleList = rdi.getAllRoles();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("roleList",roleList);
        req.getRequestDispatcher("tableShow.jsp").forward(req, resp);
    }
}
