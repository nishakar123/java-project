package shopping.cart.enums;

public enum ProductPrice {
    cheerios(5.34),
    cornflakes(2.52),
    frosties(7.21),
    shreddies(4.98),
    weetabix(9.98);

    private final double price;

    ProductPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
