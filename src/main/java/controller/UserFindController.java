package controller;

import dao.RoleDaoImplements;
import dao.UserDaoImplements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Role;
import pojo.User;

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
public class UserFindController extends HttpServlet{
    private static ApplicationContext beans = new ClassPathXmlApplicationContext("spring-conf.xml");
    UserDaoImplements udi = (UserDaoImplements) beans.getBean("userDaoImp");

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean fillRole = false;
        if(req.getParameter("name") != null){
            String userName = req.getParameter("name");
            if (req.getParameter("fillRole") != null){
                fillRole = true;
            }
            try {
                User user =  udi.findUser(userName,fillRole);

                if (user.getName() != null){
                    req.setAttribute("userFound",user.getName());
                    req.setAttribute("roleListFound",user.getRoles());
                } else {
                    req.setAttribute("errorFindNotFound", "User doesn't exists.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        req.getRequestDispatcher("formOptions.jsp").forward(req, resp);

    }
}
