package by.koreshkov.application;

import by.koreshkov.Person;
import by.koreshkov.Student;
import by.koreshkov.Teacher;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Person> employeesList() {

        List<Person> employees = new ArrayList<>();

        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String password = "koreshkov";

        String get_employees = "select id, name, age, login, password, role from employees";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(get_employees);

            while (rs.next()) {
                Person person = new Person();
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
        return employees;
    }

    public static boolean checkUser(String login, String password) {
        boolean reply = false;
        List<Person> employeesList = employeesList();
        for (Person user : employeesList) {
            String userLogin = user.getLogin();
            String userPassword = user.getPassword();
            if (login.equals(userLogin) && password.equals(userPassword)) {
                reply = true;
                break;
            }
        }
        return reply;

    }

    public static Person user (String login) {
        Person user_temp = null;
        List<Person> employeesList = employeesList();
        for (Person user : employeesList) {
            String userLogin = user.getLogin();
            if (login.equals(userLogin)) {
                user_temp = user;
                break;
            }
        }
        return user_temp;
    }

    public static List<Student> subjectList() {

        List<Student> subjects = new ArrayList<>();

        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String password = "koreshkov";

        String get_subjects = "select id_student, subject, mark from subjects";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(get_subjects);

            while(rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id_student"));
                student.setSubject(rs.getString("subject"));
                student.setMark(rs.getInt("mark"));
                subjects.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return subjects;
    }

    public static List<Teacher> salaryList() {

        List<Teacher> salary = new ArrayList<>();

        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String password = "koreshkov";

        String get_salary = "select id_teacher, month, salary from salary";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(get_salary);

            while(rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id_teacher"));
                teacher.setMonth(rs.getString("month"));
                teacher.setSalary(rs.getInt("salary"));
                salary.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return salary;
    }
}

