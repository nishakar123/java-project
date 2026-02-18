package shopping.cart.records;

import java.util.Map;

public record ShoppingCartRecords(Map<String, Long> shoppingCarts, double subtotal, double tax, double total) {
}
