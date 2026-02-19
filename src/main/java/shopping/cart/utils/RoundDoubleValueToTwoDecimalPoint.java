package shopping.cart.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundDoubleValueToTwoDecimalPoint {

    public static double roundToTwoDecimalPoint(double value){
        return BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
