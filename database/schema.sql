CREATE  DATABASE student_management;
USE student_management;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    year INT CHECK (year BETWEEN  1 and 6),
    faculty VARCHAR(50) NOT NULL
);

CREATE TABLE courses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE student_courses (
    student_id INT,
    courses_id INT,
    PRIMARY KEY (student_id, courses_id),
    FOREIGN KEY (student_id)
        REFERENCES students(id)
        ON DELETE CASCADE,
    FOREIGN KEY (courses_id)
        REFERENCES courses(id)
        ON DELETE CASCADE
);
INSERT INTO students (name, year, faculty)
VALUES ('Ion Schimbător', 2, 'Computer Science'),
       ('Sandu Cotorobai', 1, 'Engineering');

INSERT INTO courses (name)
VALUES ('Java Programing'),
       ('Databases');