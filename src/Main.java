import model.Student;
import model.Course;
import service.StudentService;
import service.StudentServiceImpl;
import service.CourseService;
import service.CourseServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService studentService = new StudentServiceImpl();
    private static final CourseService courseService = new CourseServiceImpl();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            printMenu();

            int option = readInt("Choose an option: ");

            switch (option) {
                case 1 -> addStudent();
                case 2 -> showAllStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> addCourse();
                case 6 -> showAllCourses();
                case 0 -> {
                    System.out.println("The application is closing...");
                    running = false;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    // ================= STUDENT =================

    private static void addStudent() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        int year = readInt("Year (1-6): ");

        System.out.print("Facultate: ");
        String faculty = scanner.nextLine();

        studentService.addStudent(new Student(name, year, faculty));
        System.out.println("Student added successfully!");
    }

    private static void showAllStudents() {
        List<Student> students = studentService.getAllStudents();
        students.forEach(System.out::println);
    }

    private static void updateStudent() {
        int id = readInt("ID student: ");

        System.out.print("New name: ");
        String name = scanner.nextLine();

        int year = readInt("New year: ");

        System.out.print("New faculty: ");
        String faculty = scanner.nextLine();

        studentService.updateStudent(new Student(id, name, year, faculty));
        System.out.println("Updated student.");
    }

    private static void deleteStudent() {
        int id = readInt("Student ID to delete: ");
        studentService.deleteStudent(id);
        System.out.println("Deleted student.");
    }

    // ================= COURSE =================

    private static void addCourse() {
        System.out.print("Course name: ");
        String name = scanner.nextLine();

        courseService.addCourse(new Course(name));
        System.out.println("Course added.");
    }

    private static void showAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        courses.forEach(System.out::println);
    }

    // ================= UTIL =================

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add student");
        System.out.println("2. Show all students");
        System.out.println("3. Update student");
        System.out.println("4. Delete student");
        System.out.println("5. Add course");
        System.out.println("6. Show courses");
        System.out.println("0. Exit");
    }
}

