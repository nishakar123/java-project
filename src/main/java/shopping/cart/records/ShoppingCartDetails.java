package shopping.cart.records;

import java.util.Map;

public record ShoppingCartDetails(Map<String, Long> shoppingCarts, double subtotal, double tax, double total) {
}
