package pl.coderslab.bean.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

  private List<CartItem> cartItems =  new ArrayList<>();

  public Cart() {
  }

  public Optional<CartItem> getCartItemByProductId(Long productId){
    for (CartItem cartItem : cartItems) {
      if (cartItem.getProduct().getId().equals(productId)){
        return Optional.ofNullable(cartItem);
      }
    }
    return Optional.empty();
  }

  public void addToCart(CartItem cartItem){
    this.cartItems.add(cartItem);
  }

  public void removeFromCart(CartItem cartItem){
    this.cartItems.remove(cartItem);
  }

  public List<CartItem> getCartItems() {
    return cartItems;
  }
}