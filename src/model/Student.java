package model;

public class Student {

    private int id;
    private String name;
    private int year;
    private String faculty;

    public Student() {
    }

    public Student(String name, int year, String faculty) {
        this.name    = name;
        this.year    = year;
        this.faculty = faculty;
    }

    public Student(int id, String name, int year, String faculty) {
        this.id      = id;
        this.name    = name;
        this.year    = year;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
