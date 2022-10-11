package com.example.javaworkservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;



import sqlApp.Product;
import sqlApp.ProductDB;


@WebServlet(name = "databaseServlet", value = "/database-Servlet")
public class databaseServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ArrayList<Product> products = ProductDB.select();
    request.setAttribute("products", products);
    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
  }
}