package by.koreshkov.application;

import by.koreshkov.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class Main extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Student> students;
      //  String first_name = req.getParameter("First Name");
     //   int age = Integer.parseInt(req.getParameter("Age"));
      //  int salary = Integer.parseInt(req.getParameter("Salary"));
     //   Student student1 = new Student(req.getParameter("First Name"), Integer.parseInt(req.getParameter("Age")),Integer.parseInt(req.getParameter("Salary")));
        //Student student1 = new Student(first_name, age, salary);
        //students.add(
                //new Student(req.getParameter("First Name"),Integer.parseInt(req.getParameter("Age")), Integer.parseInt(req.getParameter("Salary"))));
        HttpSession session = req.getSession();
      //  session.setAttribute("empl1", student1);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/info");
        requestDispatcher.forward(req, resp);





    }
}