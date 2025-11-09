import java.sql.*;
import java.time.LocalDate;

public class StudentDAO {

    /*
    Method: getAllStudents
    Purpose: Retrieve and display all students from the students table
     */
    public void getAllStudents() {
        String query = "SELECT * FROM students";

        try (
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String date = resultSet.getString("enrollment_date");

                System.out.printf("%d | %s %s | %s | %s%n", id, firstName, lastName, email, date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Method: addStudent
    Purpose: Adds a student to the student table
    Return: Returns the ID of the added student or -1 on failure
     */
    public int addStudent(String first_name, String last_name, String email, LocalDate enrollment_date) {
        String query = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, email);
            ps.setDate(4, java.sql.Date.valueOf(enrollment_date));

            int affected = ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                } else {
                    System.err.println("Obtaining student_id failed");
                    return -1;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    /*
    Method: updateStudentEmail
    Purpose: Update the email of a student with a specified ID
    Return: Returns true if the change was successful, false if it was not
     */
    public boolean updateStudentEmail(int studentId, String newEmail) {
        String query = "UPDATE students SET email = ? WHERE student_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, newEmail);
            ps.setInt(2, studentId);

            int affected = ps.executeUpdate();
            return affected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
    Method: deleteStudent
    Purpose: Removes a student with the specified ID
    Return: Returns true if successful, otherwise false
     */
    public boolean deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, studentId);
            int affected = ps.executeUpdate();
            return affected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
