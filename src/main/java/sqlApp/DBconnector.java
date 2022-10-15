package sqlApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnector {
  public static Connection initializeDatabase()
      throws SQLException, ClassNotFoundException
  {
    // Initialize all the information regarding
    // Database Connection

     String url = "jdbc:postgresql://localhost:8081/postgres";
     String username = "postgres";
     String password = "sadid333";

    Connection con = DriverManager.getConnection(url,
        username,
        password);
    return con;
  }
}