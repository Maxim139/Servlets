package by.koreshkov.application;

import by.koreshkov.Person;
import by.koreshkov.Student;

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

import static by.koreshkov.application.Main.subjectList;

@WebServlet("/authorization")
public class Authorization extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String adminLogin = getServletConfig().getInitParameter("login");
        String adminPassword = getServletConfig().getInitParameter("password");
        boolean admin = adminLogin.equals(login) && adminPassword.equals(password);
        if (Main.checkUser(login, password) || admin) {
            //String role = Main.role(login);
            Person user = Main.user(login);
            String role = user.getRole();
            if (admin)
            {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                ServletContext context = req.getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher("/adminStartPage");
                dispatcher.forward(req, resp);
            }
            if (role.equals("teacher"))
            {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                ServletContext context = req.getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher("/teacherStartPage");
                dispatcher.forward(req, resp);
            }
            if (role.equals("student"))
            {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                List<Student> sub_marks = new ArrayList<>();
                List<Student> list = Main.subjectList();
                for(Student student: list) {
                    if (student.getId() == user.getId()) {
                        Student student_temp = new Student();
                        student_temp.setSubject(student.getSubject());
                        student_temp.setMark(student.getMark());
                        sub_marks.add(student_temp);
                    }
                }
              //  HttpSession session = req.getSession();
                session.setAttribute("marks", sub_marks);
                ServletContext context = req.getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher("/studentStartPage");
                dispatcher.forward(req, resp);
            }

        }
    }
}
