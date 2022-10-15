package singltoneBean;

import com.example.javaworkservlet.timerJavaServise;
import jakarta.annotation.ManagedBean;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import java.sql.SQLException;

@ManagedBean
public class FormController {
   public String onSumbit() throws SQLException, ClassNotFoundException {
time.scheduleTimeout(200) ;


return  onSumbit() ;
   }


  @ViewScoped
  @EJB
  timerJavaServise time;
}
