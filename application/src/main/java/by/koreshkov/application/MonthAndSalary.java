package by.koreshkov.application;


import by.koreshkov.Person;
import by.koreshkov.Student;
import by.koreshkov.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/salary")
public class MonthAndSalary extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> monthSalary = new ArrayList<>();
        List<Teacher> list = Main.salaryList();
        HttpSession session = req.getSession();
        Person user = (Person) session.getAttribute("user");
        for (Teacher teacher: list) {
            if (teacher.getId() == user.getId()) {
                Teacher teacher_temp = new Teacher();
                teacher_temp.setMonth(teacher.getMonth());
                teacher_temp.setSalary(teacher.getSalary());
                monthSalary.add(teacher_temp);
            }
        }
        //HttpSession session = req.getSession();
        session.setAttribute("salary", monthSalary);
        ServletContext context = req.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/salary");
        dispatcher.forward(req, resp);

    }
}
