package pl.coderslab.bean.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.bean.shop.Cart;
import pl.coderslab.bean.shop.CartItem;
import pl.coderslab.bean.shop.Product;
import pl.coderslab.bean.shop.ProductDao;

@Controller
public class CartController {

  private Cart cart;
  private ProductDao productDao;

  public CartController(Cart cart, ProductDao productDao) {
    this.cart = cart;
    this.productDao = productDao;
  }

  @RequestMapping("/addtocart/{id}/{quantity}")
  @ResponseBody
  public String addtocart(@PathVariable Long id, @PathVariable int quantity) {

    Product product = productDao.getList()
                                .get(id);

    cart.getCartItemByProductId(id)
        .map(cartItem -> {
          cart.removeFromCart(cartItem);
          cart.addToCart(new CartItem(product, cartItem.getQuantity() + quantity));
          return null;
        }).orElseGet(() -> {
          cart.addToCart(new CartItem(product, quantity));
          return null;
        });

    return "addtocart";
  }

  @GetMapping(path = "/cart", produces = "text/plain; charset=UTF-8")
  @ResponseBody
  public String cart(Model model) {
    List<CartItem> cartItems = cart.getCartItems();

    int productsCount = cartItems.size();

    int totalQuantity = cartItems.stream().map(CartItem::getQuantity)
                                 .reduce(Integer::sum).orElseGet(() -> 0);

    Double totalPrice = cartItems.stream()
                                 .map(cartItem -> cartItem.getProduct()
                                                          .getPrice() * cartItem.getQuantity())
                                 .reduce(Double::sum)
                                 .orElseGet(() -> 0.0);

//    return cartItems.stream()
//                    .map(cartItem -> {
//                      String name = cartItem.getProduct()
//                                            .getName();
//                      int quantity = cartItem.getQuantity();
//                      return String.format("%s - %d szt.", name, quantity);
//                    })
//                    .collect(Collectors.joining("; "));

    return String.format("W koszyku jest %d pozycji.\nW koszyku jest %d produktów.\nWartość koszyka to: %s.", productsCount, totalQuantity,
        totalPrice);
  }
}
