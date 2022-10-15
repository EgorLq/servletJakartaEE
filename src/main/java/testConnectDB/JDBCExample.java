package testConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

public class JDBCExample {

  public static void main(String[] args) {

    Timer timer = new Timer();

    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        {
          try (Connection conn = DriverManager.getConnection(
              "jdbc:postgresql://localhost:8081/postgres", "postgres", "password")) {
            Statement stmt = conn.createStatement();
            // выполняем запрос delete SQL
            stmt.execute("DELETE FROM \"lastName\"\n"
                + "WHERE \"time_Set\" < CURRENT_TIME - interval '10 minute'");
            System.out.println("Deleted");
          } catch (Exception e) {
            e.printStackTrace();
          }


        }

      }
    },0, 5000);

  }
}