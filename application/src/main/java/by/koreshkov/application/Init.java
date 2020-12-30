package by.koreshkov.application;

import Repository.Users;
import by.koreshkov.Administrator;

import javax.naming.Context;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Init  {

    public void init(ServletConfig config)
     {
        Administrator admin = new Administrator(config.getInitParameter("name"),
                Integer.parseInt(config.getInitParameter("age")));
        admin.setLogin(config.getInitParameter("login"));
        admin.setPassword(config.getInitParameter("password"));
        admin.setRole(config.getInitParameter("admin"));
        Users user = new Users();
        user.save(admin);

    }
}
