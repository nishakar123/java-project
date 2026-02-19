package shopping.cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shopping.cart.enums.ProductPrice;
import shopping.cart.model.Product;
import shopping.cart.service.impl.ShoppingCartServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartServiceImplTest {

    private ShoppingCartServiceImpl shoppingCartServiceImpl;

    @BeforeEach
    void setUp() {
        Product product1 = new Product(ProductPrice.cornflakes.name(), 1, ProductPrice.cornflakes.getPrice());
        Product product2 = new Product(ProductPrice.cornflakes.name(), 1, ProductPrice.cornflakes.getPrice());
        Product product3 = new Product(ProductPrice.weetabix.name(), 1, ProductPrice.weetabix.getPrice());
        shoppingCartServiceImpl = new ShoppingCartServiceImpl();
        shoppingCartServiceImpl.addProduct(product1);
        shoppingCartServiceImpl.addProduct(product2);
        shoppingCartServiceImpl.addProduct(product3);
    }

    @Test
    public void testSubTotalAmountWithoutTax() {
        assertEquals(15.02, shoppingCartServiceImpl.getSubTotalAmountWithoutTax());
    }

    @Test
    public void testAddOneMoreProduct() {
        Product product4 = new Product(ProductPrice.frosties.name(), 1, ProductPrice.frosties.getPrice());
        shoppingCartServiceImpl.addProduct(product4);
        assertEquals(22.23, shoppingCartServiceImpl.getSubTotalAmountWithoutTax());
    }

    @Test
    public void testSubTotalWithTax() {
        assert(shoppingCartServiceImpl.getSubTotalAmountWithoutTax() == 15.02);
    }

    @Test
    public void testSubTotalWithoutTax() {
        assert(shoppingCartServiceImpl.getTotalSumAmountWithTaxOnCartProducts() == 16.9);
    }

    @Test
    public void testTotalPrice() {
        assertNotEquals(22.25, shoppingCartServiceImpl.getSubTotalAmountWithoutTax());
    }

    @Test
    public void testProductPrice() {
        assertEquals(1.88,  shoppingCartServiceImpl.getTotalTaxOnCartProducts());
        assertEquals(15.02,  shoppingCartServiceImpl.getSubTotalAmountWithoutTax());
        assertEquals(16.9,  shoppingCartServiceImpl.getTotalSumAmountWithTaxOnCartProducts());
    }

    @Test
    public void testGetShoppingCart() {
        assertNotNull(shoppingCartServiceImpl.getShoppingCart());
        assertEquals(2, shoppingCartServiceImpl.getShoppingCart().getProducts().size());
        Product product4 = new Product(ProductPrice.frosties.name(), 1, ProductPrice.frosties.getPrice());
        shoppingCartServiceImpl.addProduct(product4);
        assertEquals(3, shoppingCartServiceImpl.getShoppingCart().getProducts().size());
    }

}
