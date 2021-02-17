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

@WebServlet("/updateSubjAndMarks")
public class UpdateSubjAndMarks extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = 0, mark = 0;

        if(!req.getParameter("id").equals("")) {
            id = Integer.parseInt(req.getParameter("id"));
        }
        if(!req.getParameter("mark").equals("")) {
            mark = Integer.parseInt(req.getParameter("mark"));
        }

        String subject = req.getParameter("subject");

        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String pass = "koreshkov";

        String upMark = "UPDATE subjects SET mark ="+mark+"WHERE subject = '"+subject+"' AND id_student="+id;
        String delete = "DELETE FROM subjects WHERE id_student="+id+" AND subject='"+subject+"'";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            if (id != 0 && !subject.equals("") && mark != 0) {
                Statement statement = connection.createStatement();
                statement.execute(upMark);
            }
            if (id != 0 && !subject.equals("") && mark == 0) {
                Statement statement = connection.createStatement();
                statement.execute(delete);
            }

            ServletContext context = req.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/updateSubjAndMarksJSP");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
