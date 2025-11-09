import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Connecting to database...");
        StudentDAO dao = new StudentDAO();
        dao.getAllStudents();
        //int JacobID = dao.addStudent("Jacob","Turner","jacob.turner@gmail.com", LocalDate.of(2023, 9, 3));
        //dao.updateStudentEmail(9, "jacob.turner@example.com");
        //dao.deleteStudent(9);

    }
}