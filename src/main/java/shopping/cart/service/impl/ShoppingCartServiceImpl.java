package shopping.cart.service.impl;

import shopping.cart.model.Product;
import shopping.cart.model.ShoppingCart;
import shopping.cart.service.ShoppingCartService;
import shopping.cart.utils.Constants;

import java.util.ArrayList;

import static shopping.cart.utils.RoundDoubleValueToTwoDecimalPoint.roundToTwoDecimalPoint;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    ShoppingCart shoppingCart = new ShoppingCart();

    @Override
    public void addProduct(Product product) {
        shoppingCart.getProducts()
                .computeIfAbsent(product.getName(), x -> new ArrayList<>())
                .add(product);
    }

    @Override
    public Double getSubTotalAmountWithoutTax() {
        final double subTotal = shoppingCart.getProducts().values().stream()
                .flatMapToDouble(x -> x.stream().mapToDouble(Product::getPrice)).sum();
        return roundToTwoDecimalPoint(subTotal);
    }

    @Override
    public Double getTotalTaxOnCartProducts() {
        final double subTotal = shoppingCart.getProducts().values().stream()
                .flatMapToDouble(x -> x.stream().mapToDouble(Product::getPrice)).sum();
        return roundToTwoDecimalPoint(subTotal * Constants.tax);
    }

    @Override
    public Double getTotalSumAmountWithTaxOnCartProducts() {
        final double subTotal = shoppingCart.getProducts().values().stream()
                .flatMapToDouble(x -> x.stream().mapToDouble(Product::getPrice)).sum();
        final double tax = subTotal * Constants.tax;
        return roundToTwoDecimalPoint(subTotal + tax);
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }
}
