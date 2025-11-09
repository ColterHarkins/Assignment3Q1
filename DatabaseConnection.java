import java.sql.Connection;
import java.sql.DriverManager;

/*
Class: DatabaseConnection
Purpose: Offload the job of connecting to a database from StudentDAO
 */
public class DatabaseConnection {
    static String url = "jdbc:postgresql://localhost:5432/student";
    static String user = "postgres";
    static String password = "Mario797";

    /*
    Method: getConnection
    Purpose: Establish a connection with the postgreSQL server
     */
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }
}