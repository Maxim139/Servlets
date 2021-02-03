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

@WebServlet("/updateSalary")
public class UpdateSalary extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        int salary = Integer.parseInt(req.getParameter("salary"));
        String month = req.getParameter("month");

        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String pass = "koreshkov";

        String upSalary = "UPDATE salary SET salary=" + salary + "WHERE id=" + id;
        String upMonth = "UPDATE salary SET name=" + month + "WHERE id=" + id;
        String delete = "DELETE FROM salary WHERE id="+id;

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            if (month != null) {
                PreparedStatement statement = connection.prepareStatement(upMonth);
                statement.executeUpdate();
            }
            if (salary != 0) {
                PreparedStatement statement = connection.prepareStatement(upSalary);
                statement.executeUpdate();
            }
            if (id != 0 && month == null && salary == 0) {
                PreparedStatement statement = connection.prepareStatement(delete);
                statement.executeUpdate();
            }

            ServletContext context = req.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/updateSalaryJSP");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
