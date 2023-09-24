package pl.coderslab.bean.shop;

public class Product {

  private String name;
  private Double price;

  private long id;


  public Product() {
  }

  public Product(String name, Double price, long id) {
    this.name = name;
    this.price = price;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}