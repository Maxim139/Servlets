package by.koreshkov.application;

import by.koreshkov.Person;
import by.koreshkov.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Person> employees = new ArrayList<>();
    static List<Student> subjects = new ArrayList<>();
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Employees";
        String user = "postgres";
        String password = "koreshkov";



        String get_employees = "select id, name, age, login, password, role from employees";
        String get_subjects = "select id_student, subject, mark from subjects";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(get_employees);

            while(rs.next())
            {
                Person person = new Person();
                person.setAge(rs.getInt("age"));
                person.setLogin(rs.getString("login"));
                person.setName(rs.getString("name"));
                person.setRole(rs.getString("role"));
                person.setPassword(rs.getString("password"));
                employees.add(person);

            }
        } catch (SQLException e){
            e.printStackTrace();

        }

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(get_subjects);

            while(rs.next())
            {
                Student student = new Student();
                student.setId(rs.getInt("id_student"));
                student.setSubject(rs.getString("subject"));
                student.setMark(rs.getInt("mark"));
                subjects.add(student);

            }
        } catch (SQLException e){
            e.printStackTrace();

        }
      /*  for(Person list: employees){
            System.out.println(list);
        }*/


    }

    public static boolean checkUser(String login, String password) {
        boolean reply = false;
        for (Person user : employees) {
            String userLogin = user.getLogin();
            String userPassword = user.getPassword();
            if (login.equals(userLogin) && password.equals(userPassword)) {
                reply = true;
                break;
            }
        }
        return reply;

    }

    public static Person user (String login){
        Person user_temp = null;
        //String userRole="undefined";
        for (Person user : employees){
            String userLogin = user.getLogin();
            if (login.equals(userLogin)){
                user_temp = user;
              // userRole = user.getRole();
               break;
            }
        }
        return user_temp;
        //return userRole;
    }

    public static List<Student> subjectList(){
        return subjects;
    }


}

