package pl.coderslab.bean.controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.bean.shop.Cart;
import pl.coderslab.bean.shop.CartItem;
import pl.coderslab.bean.shop.Product;

@Controller
public class CartController {

  private Cart cart;

  public CartController(Cart cart) { //wstrzykujemy zależność przez konstruktor
    this.cart = cart;
  }

  @RequestMapping("/addtocart")
  @ResponseBody
  public String addtocart() {
    Random rand = new Random();
    int id = rand.nextInt(10);
    double price = rand.nextDouble();

    cart.addToCart(new CartItem(new Product("prod" + id, price), 1));

    return "Added to cart";
  }

  @GetMapping("/cart")
  @ResponseBody
  public String cart(Model model) {
    List<CartItem> cartItems = cart.getCartItems();
    return cartItems.stream()
             .map(cartItem -> {
               String name = cartItem.getProduct().getName();
               int quantity = cartItem.getQuantity();
               return String.format("%s - %d szt.", name, quantity);
             })
             .collect(Collectors.joining("; "));
  }
}
