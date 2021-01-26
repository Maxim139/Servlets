package by.koreshkov.application;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/insertSalary")
public class insertSalary extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String month = req.getParameter("month");
        String salary = req.getParameter("salary");

        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String pass = "koreshkov";

        String insert_subjects = "INSERT INTO salary(id_teacher, month, salary) VALUES " +
                "(" + id + ","
                + month + ","
                + salary + ")";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(insert_subjects);

            statement.executeUpdate();

            ServletContext context = req.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/insertSalaryJSP");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
