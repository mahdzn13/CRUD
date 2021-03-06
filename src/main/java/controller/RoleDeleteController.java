package controller;

import dao.RoleDaoImplements;
import dao.UserDaoImplements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Marco on 15/02/2017.
 */
public class RoleDeleteController extends HttpServlet{
    private static ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
    RoleDaoImplements rdi = (RoleDaoImplements) beans.getBean("roleDaoImp");

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleName = req.getParameter("roleNameDelete");

        try {
            rdi.deleteRole(roleName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("roleDelSuccessful", roleName);
        req.getRequestDispatcher("formOptions.jsp").forward(req, resp);

    }
}