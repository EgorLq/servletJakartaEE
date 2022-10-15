package com.example.javaworkservlet;


import jakarta.annotation.Resource;
import jakarta.ejb.Schedule;
import jakarta.ejb.Timeout;
import jakarta.ejb.Timer;
import jakarta.ejb.TimerService;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import sqlApp.DBconnector;

public class timerJavaServise {
  @Resource
  TimerService timerServise ;
  private  static  final Logger logger =Logger.getLogger("com.example.javaworkservlet.timerJavaServise");
  public  timerJavaServise() {

  }
  public void setTimer(long interval) {
    timerServise.createTimer(interval ,  " Setting a programmtic timer ") ;
  }

  @Timeout
  public  void programmaticTimeout(Timer timer ) {
    logger.info("@Timeout in programmitc timer at" + new java.util.Date());

  }
  @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
  public void  scheduleTimeout(final int t) throws SQLException, ClassNotFoundException {
    Connection conn = DBconnector.initializeDatabase();
    Statement stmt = conn.createStatement();
    // выполняем запрос delete SQL
    stmt.execute("DELETE FROM \"lastName\"\n"
        + "WHERE \"time_Set\" < CURRENT_TIME - interval '10 minute'");
    logger.info("Deleted");
  }
}
