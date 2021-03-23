package by.koreshkov;

public class Teacher extends Person{

    private String month;
    private int salary;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "month='" + month + '\'' +
                ", salary=" + salary +
                '}';
    }
}

