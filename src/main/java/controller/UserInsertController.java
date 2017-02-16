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
import java.util.ArrayList;
import java.util.List;

public class UserInsertController extends HttpServlet {
    private static ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
    UserDaoImplements udi = (UserDaoImplements) beans.getBean("userDaoImp");
    RoleDaoImplements rdi = (RoleDaoImplements) beans.getBean("roleDaoImp");
    private List<Role> roleList = new ArrayList<Role>();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            roleList = rdi.getAllRoles();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("roleList", roleList);
        req.getRequestDispatcher("formOptions.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName;
        String userPass;
        String[] roles;
        if (req.getParameter("name") != null){
            userName = req.getParameter("name");
            userPass = req.getParameter("pass");
            roles = req.getParameterValues("role");

            try {
                udi.insertUser(userName,userPass,roles);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("userAddSuccessful", userName);
        }

        req.getRequestDispatcher("formOptions.jsp").forward(req, resp);
    }
}
