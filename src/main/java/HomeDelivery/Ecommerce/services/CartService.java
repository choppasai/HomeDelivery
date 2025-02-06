package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Repository.CartRepo;

import HomeDelivery.Ecommerce.Repository.ProductRepo;

import HomeDelivery.Ecommerce.models.Cart;

import HomeDelivery.Ecommerce.models.Products;

import HomeDelivery.Ecommerce.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CartService {
    private final CartRepo cartRepo;
    private final ProductRepo productRepo;

    public CartService(CartRepo cartRepo, ProductRepo productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }
    public Cart createCart(UserModel user){
        Cart cart = new Cart();
        cart.setCartId(UUID.randomUUID());
        cart.setUserId(user.getUserId());
        cart.setProductsList(new ArrayList<>());
        return cart;
    }

    public Cart addToCart(Integer cartId, int productId) throws Exception {
        Optional<Cart> cartOptional =  cartRepo.findById(cartId);
        Optional<Products> productsOptional =  productRepo.findById(productId);
        if(cartOptional.isPresent() && productsOptional.isPresent()){

            Cart cart = cartOptional.get();
            Products products = productsOptional.get();
//            products.setCart(cart);
            List<Products> s = cart.getProductsList();
            s.add(products);
            cart.setProductsList(s);
            cartRepo.save(cart);
            return cart;
        }
        else {
            if(cartOptional.isPresent()){
                 throw new Exception(" product id is not present");
            }
            else
                throw new Exception("cart id is not present");
        }
//        Cart cart = new Cart();
//        cartDTO.get
//        Set<Products> ls = cart.getProductsList();
//        Products products = new Products();
//        products.setTitle(cartDTO.getProductName());
//        products.setPrice(cartDTO.getPrice());
//        Category category = new Category();
//        category.setCategory
//
//        Name(cartDTO.getCategory());
//        categoryRepo.save(category);
//        products.setCategory(category);
//        productRepo.save(products);
//        ls.add(products);
//        cart.setProductsList(ls);
//        cartRepo.save(cart);
    }
}
