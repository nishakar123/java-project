import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shopping.cart.enums.ProductPrice;
import shopping.cart.model.Product;
import shopping.cart.service.impl.ProductServiceImpl;
import shopping.cart.service.impl.ShoppingCartProductsServiceImpl;
import shopping.cart.service.impl.ShoppingCartServiceImpl;

public class ShoppingCartProductsServiceImplTest {

    private ShoppingCartProductsServiceImpl shoppingCartProductServiceImpl;

    @BeforeEach
    void setUp() {
        Product product1 = new Product(ProductPrice.cornflakes.name(), 1, ProductPrice.cornflakes.getPrice());
        Product product2 = new Product(ProductPrice.cornflakes.name(), 1, ProductPrice.cornflakes.getPrice());
        Product product3 = new Product(ProductPrice.weetabix.name(), 1, ProductPrice.weetabix.getPrice());

        ShoppingCartServiceImpl shoppingCartServiceImpl = new ShoppingCartServiceImpl();
        shoppingCartServiceImpl.addProductInShoppingCart(product1);
        shoppingCartServiceImpl.addProductInShoppingCart(product2);
        shoppingCartServiceImpl.addProductInShoppingCart(product3);

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(shoppingCartServiceImpl);

        shoppingCartProductServiceImpl = new ShoppingCartProductsServiceImpl(shoppingCartServiceImpl, productServiceImpl);
    }

    @Test
    public void testGetShoppingCartRecords() {
        shoppingCartProductServiceImpl.getShoppingCartRecords();
        assert(shoppingCartProductServiceImpl.getShoppingCartRecords().tax() == 1.88);
        assert(shoppingCartProductServiceImpl.getShoppingCartRecords().shoppingCarts().size() == 2);
    }

}
