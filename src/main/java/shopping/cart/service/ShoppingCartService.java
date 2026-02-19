package shopping.cart.service;

import shopping.cart.model.Product;

public interface ShoppingCartService {
    void addProduct(Product product);
    Double getSubTotalAmountWithoutTax();
    Double getTotalTaxOnCartProducts();
    Double getTotalSumAmountWithTaxOnCartProducts();
}
