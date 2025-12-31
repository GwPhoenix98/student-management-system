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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id="        + id +
                ", name="    + name +
                ", year="    + year +
                ", faculty=" + faculty +
                '}';
    }
}
