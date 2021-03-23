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

@WebServlet("/updateSalary")
public class UpdateSalary extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = 0, salary = 0;

        if (!req.getParameter("id").equals("")) {
            id = Integer.parseInt(req.getParameter("id"));
        }
        if (!req.getParameter("salary").equals("")) {
            salary = Integer.parseInt(req.getParameter("salary"));
        }

        String month = req.getParameter("month");

        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String pass = "koreshkov";

        String upSalary = "UPDATE salary SET salary=" + salary + "WHERE id_teacher=" +id+" AND month='"+month+"'";
        String delete = "DELETE FROM salary WHERE id_teacher="+id+"AND month='"+month+"'";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            if (!month.equals("")) {
                Statement statement = connection.createStatement();
                statement.execute(upSalary);
            }
            if (salary != 0) {
                Statement statement = connection.createStatement();
                statement.execute(upSalary);
            }
            if (id != 0 && !month.equals("") && salary == 0) {
                Statement statement = connection.createStatement();
                statement.execute(delete);
            }

            ServletContext context = req.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/updateSalaryJSP");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
