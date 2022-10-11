package com.example.javaworkservlet;
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


@WebServlet(name = "connectSQL", value ="/products")
public class connectSQL extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();

    try (Connection conn = DriverManager.getConnection(
        "jdbc:postgresql://localhost:8081/postgres", "postgres", "sadid333")) {

      writer.println("Connection to ProductDB succesfull!");
    } catch (Exception ex) {
      writer.println("Connection failed...");
      writer.println(ex);
    } finally {
      writer.close();
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
