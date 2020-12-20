package by.koreshkov.application;

import by.koreshkov.Employee;

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

        List<Employee> employees;
      //  String first_name = req.getParameter("First Name");
     //   int age = Integer.parseInt(req.getParameter("Age"));
      //  int salary = Integer.parseInt(req.getParameter("Salary"));
        Employee employee1 = new Employee(req.getParameter("First Name"), Integer.parseInt(req.getParameter("Age")),Integer.parseInt(req.getParameter("Salary")));
        //Employee employee1 = new Employee(first_name, age, salary);
        //employees.add(
                //new Employee(req.getParameter("First Name"),Integer.parseInt(req.getParameter("Age")), Integer.parseInt(req.getParameter("Salary"))));
        HttpSession session = req.getSession();
        session.setAttribute("empl1", employee1);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/info");
        requestDispatcher.forward(req, resp);





    }
}