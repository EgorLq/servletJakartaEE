package com.example.javaworkservlet;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {


    String firstName = request.getParameter("name");

    response.getWriter().println("<h1>Hello " + firstName + "!</h1>");
  }
}
