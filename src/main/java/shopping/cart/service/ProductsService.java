package shopping.cart.service;

import shopping.cart.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductsService {
    List<Product> getAllProductsFromShoppingCart();
    Map<String, Long> getProductsWithCount();
}
