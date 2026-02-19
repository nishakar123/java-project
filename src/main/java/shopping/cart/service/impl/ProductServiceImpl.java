package shopping.cart.service.impl;

import shopping.cart.model.Product;
import shopping.cart.service.ProductsService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductsService {

    private final ShoppingCartServiceImpl shoppingCartServiceImpl;

    public ProductServiceImpl(ShoppingCartServiceImpl shoppingCartServiceImpl) {
        this.shoppingCartServiceImpl = shoppingCartServiceImpl;
    }

    @Override
    public List<Product> getAllProductsFromShoppingCart() {
        return shoppingCartServiceImpl.getShoppingCart().getProducts().values().stream().flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Long> getProductsWithCount() {
        return this.getAllProductsFromShoppingCart().stream()
                .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
    }
}
