package dao;

import model.Student;
import util.DBConnection;
import exception.StudentNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO students(name, year, faculty) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getYear());
            stmt.setString(3, student.getFaculty());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding student", e);
        }
    }

    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("year"),
                        rs.getString("faculty")
                );
            } else {
                throw new StudentNotFoundException("Student with id " + id + " does not exist.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Student reading error", e);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        List<Student> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("year"),
                        rs.getString("faculty")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Student reading error", e);
        }

        return list;
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, year=?, faculty=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getYear());
            stmt.setString(3, student.getFaculty());
            stmt.setInt(4, student.getId());

            int rows = stmt.executeUpdate();

            if (rows == 0) {
                throw new StudentNotFoundException("Nonexistent student.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Student reading error", e);
        }
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new StudentNotFoundException("Nonexistent student.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Student reading error", e);
        }
    }
}
