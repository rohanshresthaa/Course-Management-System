DROP DATABASE CMS;
CREATE DATABASE CMS;

USE CMS;

CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100) NOT NULL
);
INSERT INTO courses(course_name) VALUES 
    ('BSc. Computer Science'), 
    ('BSc. Information Technology'), 
    ('BSc. Computer Engineering');
CREATE TABLE modules (
    module_id INT PRIMARY KEY AUTO_INCREMENT,
    module_name VARCHAR(100) NOT NULL,
    module_type VARCHAR(100) NOT NULL,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);
INSERT INTO modules (module_name,module_type, course_id) VALUES 
    ('Programming Fundamentals','core', 1),
    ('Data Structures','core', 1),
    ('Database Management Systems','core', 1),
    ('Computer Networks','optional', 1),
    ('Operating Systems','optional', 1),
    ('Programming Fundamentals','core', 2),
    ('Data Structures','core', 2),
    ('Database Management Systems','core', 2),
    ('Computer Networks','optional', 2),
    ('Operating Systems','optional', 2),
    ('Programming Fundamentals','core', 3),
    ('Data Structures','core', 3),
    ('Database Management Systems','core', 3),
    ('Computer Networks','optional', 3),
    ('Operating Systems','optional', 3);
CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100) NOT NULL,
    course_id INT NOT NULL,
    student_email VARCHAR(100) NOT NULL UNIQUE,
    student_password VARCHAR(100) NOT NULL,
    student_phone VARCHAR(100) NOT NULL,
    level INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);
INSERT INTO students (student_name, course_id, student_email, student_password, student_phone, level) VALUES 
    ('Rohan Shrestha', 1, 'rohan@gmail.com','rohan@123','1234567890', 1);

CREATE TABLE instructors (
    instructor_id INT PRIMARY KEY AUTO_INCREMENT,
    instructor_name VARCHAR(100) NOT NULL,
    instructor_email VARCHAR(100) NOT NULL UNIQUE,
    instructor_password VARCHAR(100) NOT NULL,
    instructor_phone VARCHAR(100) NOT NULL
);
INSERT INTO instructors (instructor_name, instructor_email, instructor_password, instructor_phone) VALUES 
    ('John Cena', 'john@gmail.com','john@123','1234567890'),
    ('John Wick', 'wick@gmail.com','wick@123','1234567890')
    ;

CREATE TABLE enrollments (
    student_id INT NOT NULL,
    module_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (module_id) REFERENCES modules(module_id),
    PRIMARY KEY (student_id, module_id)
);
INSERT INTO enrollments (student_id, module_id) VALUES 
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5)
    ;

CREATE TABLE results (
    student_id INT NOT NULL,
    module_id INT NOT NULL,
    marks INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (module_id) REFERENCES modules(module_id),
    PRIMARY KEY (student_id, module_id)
);
INSERT INTO results (student_id, module_id, marks) VALUES 
    (1, 1, 80),
    (1, 2, 80),
    (1, 3, 80),
    (1, 4, 80),
    (1, 5, 80);
CREATE TABLE admin (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    admin_name VARCHAR(100) NOT NULL,
    admin_email VARCHAR(100) NOT NULL UNIQUE,
    admin_password VARCHAR(100) NOT NULL
);
INSERT INTO admin (admin_name, admin_email, admin_password) VALUES ('Admin', 'admin@123', 'admin@123');

INSERT INTO activity (activity_name, activity_date, activity_time) VALUES 
    ('Midterm Exam', '2021-03-01', '10:00:00'),
    ('Final Exam', '2021-04-01', '10:00:00');
Create table assigned_modules(
    instructor_id INT NOT NULL,
    module_id INT NOT NULL,
    FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id),
    FOREIGN KEY (module_id) REFERENCES modules(module_id),
    PRIMARY KEY (instructor_id, module_id)
);
INSERT INTO assigned_modules (instructor_id, module_id) VALUES 
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (2, 1),
    (2, 2),
    (2, 3),
    (2, 4),
    (2, 5);