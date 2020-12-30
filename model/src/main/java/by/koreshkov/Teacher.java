package by.koreshkov;

public class Teacher {

    String name;
    int age, groupId, janSalary, febSalary, marSalary, aprSalary;
    private String login, password, role;

    public Teacher(String name, int age, int janSalary, int febSalary, int marSalary, int aprSalary, int groupId) {
        this.name = name;
        this.age = age;
        this.janSalary = janSalary;
        this.febSalary = febSalary;
        this.marSalary = marSalary;
        this.aprSalary = aprSalary;
        this.groupId = groupId;
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
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", groupId=" + groupId +
                ", janSalary=" + janSalary +
                ", febSalary=" + febSalary +
                ", marSalary=" + marSalary +
                ", aprSalary=" + aprSalary +
                '}';
    }
}

