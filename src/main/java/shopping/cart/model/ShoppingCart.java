package shopping.cart.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private final Map<String, List<Product>> products = new HashMap<>();

    public ShoppingCart() {
    }

    public Map<String, List<Product>> getProducts() {
        return this.products;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "products=" + products +
                '}';
    }
}

