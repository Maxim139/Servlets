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

@WebServlet("/updateSubjAndMarks")
public class UpdateSubjAndMarks extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        int mark = Integer.parseInt(req.getParameter("mark"));
        String subject = req.getParameter("subject");

        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String pass = "koreshkov";

        String upMark = "UPDATE subjects SET mark ="+mark+"WHERE subject = "+subject+" AND id="+id;
        String delete = "DELETE FROM subjects WHERE id="+id+" AND subject="+subject;

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            if (id != 0 && subject != null && mark != 0) {
                PreparedStatement statement = connection.prepareStatement(upMark);
                statement.executeUpdate();
            }
            if (id != 0 && subject != null && mark == 0) {
                PreparedStatement statement = connection.prepareStatement(delete);
                statement.executeUpdate();
            }

            ServletContext context = req.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/updateSubjAndMarksJSP");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
