package testConnectDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet( "/test-servlet")
public class testServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  response.setContentType("text/html");
  PrintWriter writer = response.getWriter();
  try{
    String url = "jdbc:postgresql://localhost:8081/postgres";
    String username = "postgres";
    String password = "password";
    try (Connection conn = DriverManager.getConnection(url, username, password)){

      writer.println("Connection to ProductDB succesfull!");
    }
  }
  catch(Exception ex){
    writer.println("Connection failed...");
    writer.println(ex);
  }
  finally {
    writer.close();
  }
}
}
