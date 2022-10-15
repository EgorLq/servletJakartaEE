package sqlApp;


import java.io.Serializable;

public class Product implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;
  private String name;


  public Product(String name){


    this.name = name;

  }
  public Product(int id, String name){

    this.id = id;
    this.name = name;

  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  }
