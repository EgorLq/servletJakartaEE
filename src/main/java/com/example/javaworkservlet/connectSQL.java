package com.example.javaworkservlet;
import static java.lang.System.out;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet(name = "connectSQL", value ="/products1")
public class connectSQL extends HttpServlet {

  private final String url = "jdbc:postgresql://localhost:8081/postgres";
  private final String user = "postgres";
  private final String password = "password";

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();

    try {
      Connection conn = DriverManager.getConnection(
          url, user, password);
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("select * from \"lastName\"");

      out.println("<tr><th>Id</th><th>Name</th><tr>");
      while (rs.next())
      {
        String n = rs.getString("id");
        String nm = rs.getString("firstname");
        String data = rs.getString("time_set");

        response.getWriter().println("<h1>" + n + "</h1>" +"<h1>"+ nm + "</h1>"+"<h1>"+ data + "</h1>");
      }

    }
    catch (Exception e)
    {
      out.println("error");
    }
  }
}


  /*  statement.executeUpdate("insert into (name) values ('Iron')");
    statement.executeUpdate("insert into (name) values ('Dimon')");
    ResultSet resultSet = statement.executeQuery("select  * from secondname");
    while (resultSet.next()) {
    System.out.println(resultSet.getInt("id"));
    System.out.println(resultSet.getString("name")); */
/* try{
    String url = "jdbc:postgresql://localhost:8081/postgres";
    String username = "postgres";
    String password = "sadid333";

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
    } */
