package model;

public class Course {

    private int id;
    private String name;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
