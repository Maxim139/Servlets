package by.koreshkov;

import java.util.Map;
import java.util.Objects;

public class Student extends Person{

private String subject;
private int mark;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "subject='" + subject + '\'' +
                ", mark=" + mark +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return mark == student.mark &&
                Objects.equals(subject, student.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subject, mark);
    }
}
