package by.koreshkov.application;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/updatePerson")
public class UpdatePerson extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = 0, group = 0, age = 0;

        if (!req.getParameter("id").equals("")) {
            id = Integer.parseInt(req.getParameter("id"));
        }
        if (!req.getParameter("group").equals("")) {
            group = Integer.parseInt(req.getParameter("group"));
        }
        if (!req.getParameter("age").equals("")) {
            age = Integer.parseInt(req.getParameter("age"));
        }


        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");


        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String pass = "koreshkov";

        String upName = "UPDATE employees SET name='"+name+"' WHERE id="+id;
        String upAge = "UPDATE employees SET age="+age+" WHERE id="+id;
        String upLogin = "UPDATE employees SET login='"+login+"' WHERE id="+id;
        String upPassword = "UPDATE employees SET password='"+password+"' WHERE id="+id;
        String upRole = "UPDATE employees SET role='"+role+"' WHERE id="+id;
        String upGroup = "UPDATE employees SET group_number="+group+" WHERE id="+id;
        String delete = "DELETE FROM employees WHERE id="+id;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            if (!name.equals("")) {
                Statement statement = connection.createStatement();
                statement.execute(upName);
            }
            if (age != 0) {
                Statement statement = connection.createStatement();
                statement.execute(upAge);
            }
            if (!login.equals("")) {
                Statement statement = connection.createStatement();
                statement.execute(upLogin);
            }
            if (!password.equals("")) {
                Statement statement = connection.createStatement();
                statement.execute(upPassword);
            }
            if (!role.equals("")) {
                Statement statement = connection.createStatement();
                statement.execute(upRole);
            }
            if (group != 0) {
                Statement statement = connection.createStatement();
                statement.execute(upGroup);
            }
            if (id != 0 && name.equals("") && login.equals("") && password.equals("") && age == 0 && role.equals("") && group == 0) {
                Statement statement = connection.createStatement();
                statement.execute(delete);
            }

            ServletContext context = req.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/updatePersonJSP");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
