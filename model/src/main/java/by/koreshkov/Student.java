package by.koreshkov;

import java.util.Map;

public class Student {
String name;
int age, groupId;
private String login, password, role;
Map<String, Integer> SubjectAndMark;

    public Student(String name, int age, int groupId, String login) {
        this.name = name;
        this.age = age;
        this.groupId = groupId;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", groupId=" + groupId +
                '}';
    }
}
