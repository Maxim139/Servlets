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
import java.sql.*;
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
/*
                List<Person> list = new ArrayList<>();
                Person person = new Person();
                person.setId(33);
                Person person1 = new Person();
                person1.setId(22);
                list.add(person);
                list.add(person1);


 */
        List<Person> employees = new ArrayList<>();

        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String pass = "koreshkov";

        String get_employees = "select id, name, age, login, password, role from employees";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(get_employees);

            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setAge(rs.getInt("age"));
                person.setLogin(rs.getString("login"));
                person.setName(rs.getString("name"));
                person.setRole(rs.getString("role"));
                person.setPassword(rs.getString("password"));
                employees.add(person);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //System.out.println(employees);


              //  List<Student> list = Main.subjectList();
                session.setAttribute("empl", employees ); //--
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
