package singltoneBean;

import jakarta.ejb.Lock;
import jakarta.ejb.LockType;
import jakarta.ejb.Singleton;
import java.util.concurrent.atomic.AtomicBoolean;

@Singleton
public class WorkerBean {

  private AtomicBoolean busy = new AtomicBoolean(false);

  @Lock(LockType.READ)
  public void doTimerWork() throws InterruptedException {
    if (!busy.compareAndSet(false, true)) {
      return;
    }
    try {
      Thread.sleep(20000L);
    } finally {
      busy.set(false);
    }
  }
}