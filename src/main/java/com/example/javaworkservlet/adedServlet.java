package com.example.javaworkservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import sqlApp.Product;
import sqlApp.ProductDB;

@WebServlet(name = "adedServlet", value = "/aded-Servlet")
public class adedServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      String name = request.getParameter("name");
      Product product = new Product(name);
      ProductDB.insert(product);
      response.sendRedirect(request.getContextPath()+"/index");
    }
    catch(Exception ex) {

      getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }
  }
}