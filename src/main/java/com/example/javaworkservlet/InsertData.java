package com.example.javaworkservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import singltoneBean.FormController;
import sqlApp.DBconnector;


// Servlet Name
@WebServlet("/InsertData")
public class InsertData extends HttpServlet {

  private static final long serialVersionUID = 1L;
FormController formController = new FormController() ;

  public FormController getFormController() {
    return formController;
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    try {

      // Initialize the database
      Connection con = DBconnector.initializeDatabase();

      PreparedStatement st = con
          .prepareStatement("insert into public.\"lastName\" (id ,firstname , \"time_Set\") values(?, ? ,CURRENT_TIME)");
      // For the first parameter,
      // get the data using request object
      // sets the data to st pointer
      st.setInt(1, Integer.valueOf(request.getParameter("id")));

      // Same for second parameter
      st.setString(2, request.getParameter("string"));

      // Execute the insert command using executeUpdate()
      // to make changes in database
      st.executeUpdate();

      // Close all the connections
      st.close();
      con.close();

      // Get a writer pointer
      // to display the successful result
      PrintWriter out = response.getWriter();
      out.println("<html><body><b>Successfully Inserted"
          + "</b></body></html>");


    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
