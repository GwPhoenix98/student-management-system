package service;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public void addStudent(Student student) {

        if (student.getName() == null || student.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        if (student.getYear() < 1 || student.getYear() > 6) {
            throw new IllegalArgumentException("Year must be between 1 and 6");
        }

        studentDAO.addStudent(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public void updateStudent(Student student) {

        if (student.getId() <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        studentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }
}
