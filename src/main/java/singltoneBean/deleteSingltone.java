package singltoneBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Timer;
import jakarta.ejb.EJB;
import jakarta.ejb.Lock;
import jakarta.ejb.LockType;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import java.util.TimerTask;

@Singleton
public class deleteSingltone {


  public void atScheduler() throws InterruptedException {
    Timer timer = new Timer();

    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        {
          try (Connection conn = DriverManager.getConnection(
              "jdbc:postgresql://localhost:8081/postgres", "postgres", "sadid333")) {
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

