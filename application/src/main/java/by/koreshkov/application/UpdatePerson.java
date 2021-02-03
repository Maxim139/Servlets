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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/updatePerson")
public class UpdatePerson extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        int group = Integer.parseInt(req.getParameter("group"));
        int age = Integer.parseInt(req.getParameter("age"));
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");


        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String pass = "koreshkov";

        String upName = "UPDATE employees SET name="+name+"WHERE id="+id;
        String upAge = "UPDATE employees SET name="+age+"WHERE id="+id;
        String upLogin = "UPDATE employees SET name="+login+"WHERE id="+id;
        String upPassword = "UPDATE employees SET name="+password+"WHERE id="+id;
        String upRole = "UPDATE employees SET name="+role+"WHERE id="+id;
        String upGroup = "UPDATE employees SET name="+group+"WHERE id="+id;
        String delete = "DELETE FROM employees where id="+id;


        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            if (name != null) {
                PreparedStatement statement = connection.prepareStatement(upName);
                statement.executeUpdate();
            }
            if (age != 0) {
                PreparedStatement statement = connection.prepareStatement(upAge);
                statement.executeUpdate();
            }
            if (login != null) {
                PreparedStatement statement = connection.prepareStatement(upLogin);
                statement.executeUpdate();
            }
            if (password != null) {
                PreparedStatement statement = connection.prepareStatement(upPassword);
                statement.executeUpdate();
            }
            if (role != null) {
                PreparedStatement statement = connection.prepareStatement(upRole);
                statement.executeUpdate();
            }
            if (group != 0) {
                PreparedStatement statement = connection.prepareStatement(upGroup);
                statement.executeUpdate();
            }
            if (id != 0 && name == null && login == null && password == null && age == 0 && role == null && group == 0) {
                PreparedStatement statement = connection.prepareStatement(delete);
                statement.executeUpdate();
            }

            ServletContext context = req.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/updatePersonJSP");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
