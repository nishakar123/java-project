import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shopping.cart.enums.ProductPrice;
import shopping.cart.model.Product;
import shopping.cart.service.impl.ProductServiceImpl;
import shopping.cart.service.impl.ShoppingCartServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductServiceImplTest {

    private ProductServiceImpl productServiceImpl;

    @BeforeEach
    void setUp() {
        Product product1 = new Product(ProductPrice.cornflakes.name(), 1, ProductPrice.cornflakes.getPrice());
        Product product2 = new Product(ProductPrice.cornflakes.name(), 1, ProductPrice.cornflakes.getPrice());
        Product product3 = new Product(ProductPrice.weetabix.name(), 1, ProductPrice.weetabix.getPrice());
        ShoppingCartServiceImpl shoppingCartServiceImpl = new ShoppingCartServiceImpl();
        shoppingCartServiceImpl.addProductInShoppingCart(product1);
        shoppingCartServiceImpl.addProductInShoppingCart(product2);
        shoppingCartServiceImpl.addProductInShoppingCart(product3);
        productServiceImpl = new ProductServiceImpl(shoppingCartServiceImpl);
    }

    @Test
    public void testGetAllProductsFromShoppingCart() {
        assertEquals(3, productServiceImpl.getAllProductsFromShoppingCart().size());
    }

    @Test
    public void testGetAllProductsFromShoppingCartNotEquals() {
        assertNotEquals(4, productServiceImpl.getAllProductsFromShoppingCart().size());
    }

    @Test
    public void testAddProductInShoppingCart() {
        assert(productServiceImpl.getProductsWithCount().containsKey("cornflakes"));
        assert(productServiceImpl.getProductsWithCount().get("cornflakes") == 2);
    }
}
