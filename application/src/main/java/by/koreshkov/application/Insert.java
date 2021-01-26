package by.koreshkov.application;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/insert")
public class Insert extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        String group = req.getParameter("group");

        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String pass = "koreshkov";

        String insert_employee = "insert into employees(name, age, login, password, role, group) VALUES " +
                "(" + name + ","
                + age + ","
                + login + ","
                + password + ","
                + role + ","
                + group + ")";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(insert_employee);

            statement.executeUpdate();

            ServletContext context = req.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/insertPerson");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
