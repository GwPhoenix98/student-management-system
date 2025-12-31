package service;

import model.Course;

import java.util.List;

public interface CourseService {

    void addCourse(Course course);

    Course getCourseById(int id);

    List<Course> getAllCourses();

    void updateCourse(Course course);

    void deleteCourse(int id);
}
