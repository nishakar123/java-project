package shopping.cart.service.impl;

import shopping.cart.records.ShoppingCartDetails;
import shopping.cart.service.ProductsService;
import shopping.cart.service.ShoppingCartProductsService;
import shopping.cart.service.ShoppingCartService;

public class ShoppingCartProductsServiceImpl implements ShoppingCartProductsService {

    private final ShoppingCartService shoppingCartService;

    private final ProductsService productsService;

    public ShoppingCartProductsServiceImpl(ShoppingCartService shoppingCartService, ProductsService productsService) {
        this.shoppingCartService = shoppingCartService;
        this.productsService = productsService;
    }

    @Override
    public ShoppingCartDetails getShoppingCartDetails() {
        return new ShoppingCartDetails(this.productsService.getProductsWithCount(),
                this.shoppingCartService.getSubTotalAmountWithoutTax(),
                this.shoppingCartService.getTotalTaxOnCartProducts(),
                this.shoppingCartService.getTotalSumAmountWithTaxOnCartProducts());
    }
}
