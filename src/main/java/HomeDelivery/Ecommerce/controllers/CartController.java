package HomeDelivery.Ecommerce.controllers;

import HomeDelivery.Ecommerce.models.Cart;
import HomeDelivery.Ecommerce.services.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{cartId}/products/{productId}")
    public ResponseEntity<String> addingProducts(@PathVariable Integer cartId, @PathVariable int productId) throws Exception {
        Cart cart = cartService.addToCart(cartId,productId);
        System.out.println(cart.getCartId() +" "+ cart.getProductsList());
        return ResponseEntity.ok().body("product added to cart");
    }
}
