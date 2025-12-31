package service;

import dao.CourseDAO;
import dao.CourseDAOImpl;
import model.Course;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private final CourseDAO courseDAO = new CourseDAOImpl();

    @Override
    public void addCourse(Course course) {

        if (course.getName() == null || course.getName().isBlank()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }
        courseDAO.addCourse(course);
    }

    @Override
    public Course getCourseById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
        return courseDAO.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return List.of();
    }

    @Override
    public void updateCourse(Course course) {
        if (course.getId() <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        if (course.getName() == null || course.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        courseDAO.updateCourse(course);
    }

    @Override
    public void deleteCourse(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
        courseDAO.deleteCourse(id);
    }
}
