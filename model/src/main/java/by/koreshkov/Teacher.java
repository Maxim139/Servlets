package by.koreshkov;

public class Teacher {

    String name;
    int age, groupId;
    private String login, password, role;

    public Teacher(String name, int age,int groupId) {
        this.name = name;
        this.age = age;

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

                '}';
    }
}

