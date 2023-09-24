package pl.coderslab.bean.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ProductDao {

  private HashMap<Long, Product> products;

  public HashMap<Long, Product> getList() {
      return products;
  }

  public ProductDao() {
    products = new HashMap<>();
    products.put(1L, new Product("Product 1", 10.0, 1L));
    products.put(2L, new Product("Product 2", 20.0, 2L));
    products.put(3L, new Product("Product 3", 30.0, 3L));
    products.put(4L, new Product("Product 4", 40.0, 4L));
    products.put(5L, new Product("Product 5", 50.0, 5L));

  }
}
