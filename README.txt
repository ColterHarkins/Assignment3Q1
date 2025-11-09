Programmed and Completed by Colter Harkins on November 9th 2025
Colter Harkins | 101273140

This java application connects to a PostgreSQL database and performs basic CRUD operations

Database Setup:
- Start PostgreSQL on pgAdmin4
- Create a new database named 'student'
    CREATE DATABASE student
- Connect to the database
    \c student
- Create students table
    CREATE TABLE students (
        student_id SERIAL PRIMARY KEY,
        first_name TEXT NOT NULL,
        last_name TEXT NOT NULL,
        email TEXT NOT NULL UNIQUE,
        enrollment_date DATE
    );
- Insert initial data
    INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
    ('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
    ('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
    ('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');
- Ensure that the pom.xml has the PostgreSQL JDBC driver
    <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.8</version>
    </dependency>
- Configure database connection url, user and password in DatabaseConnection.java
- In Main.java use any of the provided CRUD operations
- Example:
    dao.getAllStudents();
    int JacobID = dao.addStudent("Jacob","Turner","jacob.turner@gmail.com", LocalDate.of(2023, 9, 3));
    dao.getAllStudents();
    dao.updateStudentEmail(JacobID, "jacob.turner@example.com")
    dao.getAllStudents();
    dao.deleteStudent(JacobID);
    dao.getAllStudents();
- Video link
    https://youtu.be/L24Xuy2XiQg