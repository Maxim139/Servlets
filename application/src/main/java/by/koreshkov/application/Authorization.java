package by.koreshkov.application;


import by.koreshkov.Person;
import by.koreshkov.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/authorization", initParams = {
        @WebInitParam(name = "login", value = "maxim"),
        @WebInitParam(name = "password", value = "koreshkov")
})
public class Authorization extends HttpServlet {

    private String adminPassword = "";
    private String adminLogin = "";

    public void init(ServletConfig config) throws ServletException  {
         super.init(config);
         adminLogin = getServletConfig().getInitParameter("login");
         adminPassword = getServletConfig().getInitParameter("password");
         // ServletContext context = getServletContext();
         // adminLogin = context.getInitParameter("login");
         // adminPassword = context.getInitParameter("password");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = "";
        // String adminLogin = getServletConfig().getInitParameter("login");
        // String adminPassword = getServletConfig().getInitParameter("password");
        boolean admin = adminLogin.equals(login) && adminPassword.equals(password);
      //  if (Main.checkUser(login, password) || admin) {
        //    if (!admin) { role = Main.user(login).getRole(); }
          //  if (admin) {

                HttpSession session = req.getSession();
                List<Person> list = new ArrayList<>();

                Person person = new Person();
                person.setId(35);
                list.add(person);
                int[] a = {1,2,3,4,5};
                req.setAttribute("empList", a); //--
                //session.setAttribute("user", Main.user(login));
                ServletContext context = req.getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher("/adminStartPage");
                dispatcher.forward(req, resp);
           // }
            /* if (role.equals("teacher")) {
                HttpSession session = req.getSession();
                session.setAttribute("user", Main.user(login));
                ServletContext context = req.getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher("/teacherStartPage");
                dispatcher.forward(req, resp);
            }
            if (role.equals("student")) {
                HttpSession session = req.getSession();
                session.setAttribute("user", Main.user(login));
                List<Student> sub_marks = new ArrayList<>();
                List<Student> list = Main.subjectList();
                for(Student student: list) {
                    if (student.getId() == Main.user(login).getId()) {
                        Student student_temp = new Student();
                        student_temp.setSubject(student.getSubject());
                        student_temp.setMark(student.getMark());
                        sub_marks.add(student_temp);
                    }
                }
                session.setAttribute("marks", sub_marks);
                ServletContext context = req.getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher("/studentStartPage");
                dispatcher.forward(req, resp);
            }
        }

             */
    }


}
