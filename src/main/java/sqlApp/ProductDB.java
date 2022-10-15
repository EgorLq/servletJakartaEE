package sqlApp;
import java.sql.*;
import java.util.ArrayList;

public class ProductDB {

  private static String url = "jdbc:postgresql://localhost:8081/postgres";
  private static String username = "postgres";
  private static String password = "sadid333";

  public static ArrayList<Product> select() {

    ArrayList<Product> products = new ArrayList<Product>();
    try{
      try (Connection conn = DriverManager.getConnection(url, username, password)){

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
        while(resultSet.next()){

          int id = resultSet.getInt(1);
          String name = resultSet.getString(2);
          Product product = new Product(id, name);
          products.add(product);
        }
      }
    }
    catch(Exception ex){
      System.out.println(ex);
    }
    return products;
  }
  public static Product selectOne(int id) {

    Product product = null;
    try{
      try (Connection conn = DriverManager.getConnection(url, username, password)){

        String sql = "SELECT * FROM products WHERE id=?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
          preparedStatement.setInt(1, id);
          ResultSet resultSet = preparedStatement.executeQuery();
          if(resultSet.next()){

            int prodId = resultSet.getInt(1);
            String name = resultSet.getString(2);
            product = new Product(prodId, name);
          }
        }
      }
    }
    catch(Exception ex){
      System.out.println(ex);
    }
    return product;
  }
  public static int insert(Product product) {

    try{
      try (Connection conn = DriverManager.getConnection(url, username, password)){

        String sql = "INSERT INTO products (name, price) Values (?, ?)";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
          preparedStatement.setString(1, product.getName());

          return  preparedStatement.executeUpdate();
        }
      }
    }
    catch(Exception ex){
      System.out.println(ex);
    }
    return 0;
  }

  public static int update(Product product) {

    try{
      try (Connection conn = DriverManager.getConnection(url, username, password)){

        String sql = "UPDATE products SET name = ?, price = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
          preparedStatement.setString(1, product.getName());
          preparedStatement.setInt(2, product.getId());

          return  preparedStatement.executeUpdate();
        }
      }
    }
    catch(Exception ex){
      System.out.println(ex);
    }
    return 0;
  }
  public static int delete(int id) {

    try{
      try (Connection conn = DriverManager.getConnection(url, username, password)){

        String sql = "DELETE FROM products WHERE id = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
          preparedStatement.setInt(1, id);

          return  preparedStatement.executeUpdate();
        }
      }
    }
    catch(Exception ex){
      System.out.println(ex);
    }
    return 0;
  }
}