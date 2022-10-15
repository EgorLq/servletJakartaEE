package singltoneBean;

import jakarta.ejb.EJB;
import jakarta.ejb.Lock;
import jakarta.ejb.LockType;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;

@Singleton
public class FixedTimerBean {

  @EJB
  private WorkerBean workerBean;
  @EJB
  private singltoneBean.deleteSingltone deleteSingltone ;

  @Lock(LockType.READ)
  @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
  public void atSchedule() throws InterruptedException {
    deleteSingltone.atScheduler();
  }
}